package com.javacardgame.cardgame.view;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.*;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.nio.file.*;
import java.util.*;


@SuppressWarnings("restriction")
public class TableView extends Application {
	private final static String LOCAL_PATH = "/Quests_of_the_Round_Table_rules.pdf";
	
	private static int currStage = 0;
	private static Scene scene;
	private static TextArea informationArea = new TextArea();
	private static String message = null;
	private static int clientNumber = 1;
	private static ServerSocket serverSocket;
	
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(1);
        grid.setVgap(5);
        grid.setPadding(new Insets(25, 25, 25, 25));
        switch (currStage) {
        	case 0:
        		scene = new Scene(grid, 500, 500);
            	primaryStage.setTitle("Quests of the Round Table Menu");
            	Button play = playButton(primaryStage);
            	Button howTo = howToButton();
            	HBox hbBtn = new HBox(60);
            	hbBtn.setAlignment(Pos.CENTER);
            	hbBtn.getChildren().add(howTo);
            	grid.add(hbBtn, 1, 2);
            	HBox hbBtn2 = new HBox(60);
            	hbBtn2.setAlignment(Pos.CENTER);
            	hbBtn2.getChildren().add(play);
            	grid.add(hbBtn2, 1, 0);
        		break;
        	case 1:
            	scene = new Scene(grid, 500, 500);
            	primaryStage.setTitle("Quests of the Round Table Setup");
            	break;
        	case 3:
        		serverShitForLaterBro(primaryStage,grid);
				break;
        	default:
        		break;
        }
        primaryStage.setScene(scene);
        primaryStage.show();
    }

	private Button howToButton() {
		Button btn = new Button();
        btn.setText("How To Play");
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
            	 Path startingDir = Paths.get("");
            	 String dirPath = startingDir.toAbsolutePath().toString();
            	 String filepath = dirPath+LOCAL_PATH;
            	 File file = new File(filepath);
            	
                if(!Desktop.isDesktopSupported()){
                    System.out.println("Desktop is not supported");
                    return;
                }          
                Desktop desktop = Desktop.getDesktop();
                
                if(file.exists()) {
					try {
						desktop.open(file);
					} catch (IOException e) {
						e.printStackTrace();
					}
                }else {
                	System.out.println(dirPath);
                }
            }
        });
		return btn;
	}

	private Button playButton(Stage primaryStage) {
		 Button btn = new Button();
	        btn.setText("Play");
	        
	        btn.setOnAction(new EventHandler<ActionEvent>() {
	 
	            @Override
	            public void handle(ActionEvent event) {
	            	currStage = 1;
	            	primaryStage.close();
	            	Stage newStage = new Stage();
	            	start(newStage);
	            }
	        });        
		return btn;
	}
	
	
	
	
	
	
	
	///server shit
	private void serverShitForLaterBro(Stage primaryStage,GridPane grid) {
	    try {
	        serverSocket = new ServerSocket(3333);
        	scene = new Scene(grid, 500, 500);
        	primaryStage.setTitle("Quests of the Round Table Online");
	        informationArea.appendText("Server started at " + new Date() + '\n');

	        new Thread(() -> {      	            
	            while (true) {
	                try {
	                    Socket socket = serverSocket.accept();
	                    InetAddress inetAddress = socket.getInetAddress();

	                    Platform.runLater(() -> 
	                        informationArea.appendText(
	                            "Client: " + clientNumber++
	                            + "\n\thost name: " + inetAddress.getHostName()
	                            + "\n\tIP address " + inetAddress.getHostAddress() + "\n\n"
	                        )
	                    );
	                    ClientHandler task = new ClientHandler(socket);
	                    grid.add(informationArea, 1, 2);
	                    new Thread(task).start();
	                } catch (IOException ex) {};
	            }
	        }).start();
	        serverSocket.close();
    	} catch (IOException ex) {
    		System.err.println(ex);
    	}		
	}
	
	class ClientHandler implements Runnable {
        private Socket socket;

        ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
                DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

                while (true) {
                    if (message != null) {
                        outputToClient.writeUTF(message);
                    }
                    message = inputFromClient.readUTF();
                }
            } catch(IOException e) {
                System.err.println(e);
            }
        }
	}
}