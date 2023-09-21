package control;

import javafx.scene.control.TextArea;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.lang.management.OperatingSystemMXBean;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.image.ImageView;
import models.*;
import application.AutoTest;

public class MainViewController implements Initializable {
	
    @FXML
    public  Button circle1;
    @FXML
    public  Button circle2;
    @FXML
    public  Button circle3;
    @FXML
    public  Button launch;
    @FXML
    public  Button stop;
    @FXML
    public  Button taskBtn;
    @FXML
    public  Button theoryBtn;
    @FXML
    public  Button newQuestion;
    @FXML
    public  Button checkAnswer;
    @FXML
    public  Button stopAnswer;
    @FXML
    public  Button nextQuestion;
    @FXML
    public  Button ready;
    @FXML
    public  Button startTask;
    @FXML
    public  Button ToModel;
    @FXML
    public  Button exit;
    
    @FXML
    public  Button backFIrstLpp;
    @FXML
    public  Button backSecondLpp;
    @FXML
    public  Button backThirdLpp;
    @FXML
    public  Button backFourthLpp;
    @FXML
    public  Button toSecondLpp;
    @FXML
    public  Button toThirdLpp;
    @FXML
    public  Button toFourthLpp;
    @FXML
    public  Button toFifthLpp;
    
    @FXML
    public  StackPane stackPane;
    
    @FXML
    public  Pane circlePane;
    @FXML
    public  Pane taskPane;
    @FXML
    public  Pane answerPane;
    @FXML
    public  Pane theoryPane1;
    @FXML
    public  Pane theoryPane2;
    @FXML
    public  Pane theoryPane3;
    @FXML
    public  Pane theoryPane4;
    @FXML
    public  Pane theoryPane5;
    
    @FXML
    public  Label rightLabel1;
    @FXML
    public  Label rightLabel2;
    @FXML
    public  Label rightLabel3;
    @FXML
    public  Label message;
    @FXML
    public  Label message2;
    
    @FXML
    public  TextArea taskText;
    @FXML
    public  TextArea firstTask;
    @FXML
    public  TextArea secondTask;
    @FXML
    public  TextArea thirdTask;
    @FXML
    public  TextArea fourthTask;
    @FXML
    public  TextArea taskTextAnswer;
    @FXML
    public  TextArea firstTaskAnswer;
    @FXML
    public  TextArea secondTaskAnswer;
    @FXML
    public  TextArea thirdTaskAnswer;
    @FXML
    public  TextArea fourthTaskAnswer;

    @FXML
    public  CheckBox checkA;
    @FXML
    public  CheckBox checkB;
    @FXML
    public  CheckBox checkC;
    @FXML
    public  CheckBox checkD;
    @FXML
    public  CheckBox checkAAnswer;
    @FXML
    public  CheckBox checkBAnswer;
    @FXML
    public  CheckBox checkCAnswer;
    @FXML
    public  CheckBox checkDAnswer;
    
    @FXML
    public  ImageView AGreen;
    @FXML
    public  ImageView BGreen;
    @FXML
    public  ImageView CGreen;
    @FXML
    public  ImageView DGreen;
    @FXML
    public  ImageView ARed;
    @FXML
    public  ImageView BRed;
    @FXML
    public  ImageView CRed;
    @FXML
    public  ImageView DRed;
    @FXML
    public  ImageView roundArrow1;
    @FXML
    public  ImageView roundArrow2;
    @FXML
    public  ImageView roundArrow3;
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	MemoryUsage();
    	CPUusage();
    	ModelEventsHandlers();
    	TheoryEventsHandlers();
    	TaskEventsHandlers();
    	AnswerEventsHandlers();
    	MakeTest();
    }
    
    private void MakeTest() {
    	AutoTest test = new AutoTest(this);
    	test.timeline.play();
    }
    
    private void ModelEventsHandlers() {
    	Model model = new Model(this);
    	ToModel.setOnAction(event -> model.toModelAction(event));
    	circle1.setOnAction(event -> model.circle1BtnAction(event));
        circle2.setOnAction(event -> model.circle2BtnAction(event));
        circle3.setOnAction(event -> model.circle3BtnAction(event));
        launch.setOnAction(event -> model.launchBtnAction(event));
        stop.setOnAction(event -> model.stopBtnAction(event));
    }
    
    private void TheoryEventsHandlers() {
    	Theory theory = new Theory(this);
    	theoryBtn.setOnAction(event -> theory.theoryBtnAction(event));
    	toSecondLpp.setOnAction(event -> theory.toSecondLppAction(event));
    	toThirdLpp.setOnAction(event -> theory.toThirdLppAction(event));
    	toFourthLpp.setOnAction(event -> theory.toFourthLppAction(event));
    	toFifthLpp.setOnAction(event -> theory.toFifthLppAction(event));
    	backFIrstLpp.setOnAction(event -> theory.backFirstLppAction(event));
    	backSecondLpp.setOnAction(event -> theory.backSecondLppAction(event));
    	backThirdLpp.setOnAction(event -> theory.backThirdLppAction(event));
    	backFourthLpp.setOnAction(event -> theory.backFourthLppAction(event));
    }
    
    private void TaskEventsHandlers() {
    	Task task = new Task(this);
    	taskBtn.setOnAction(event -> task.taskBtnAction(event));
    	ready.setOnAction(event -> task.readyAction(event));
    	newQuestion.setOnAction(event -> task.newQuestionAction(event));
    }
    
    private void AnswerEventsHandlers() {
    	Answer answer = new Answer(this);
    	startTask.setOnAction(event -> answer.startTaskAction(event));
    	checkAnswer.setOnAction(event -> answer.checkAnswerAction(event));
    	nextQuestion.setOnAction(event -> answer.nextQuestionAction(event));
    	stopAnswer.setOnAction(event -> answer.stopAnswerAction(event));
    }
    
    @FXML
    private void exitBtnAction(ActionEvent event) {
    	PrintAverageUsedRAM();
    	PrintAverageCPUusage();
    	Platform.exit();
    }
    
    
    public Pane CoordinatesPane = new Pane();
    
    public  void toModel() {
		CoordinatesPane.getChildren().clear();
	    stackPane.getChildren().clear();
	    stackPane.getChildren().add(circlePane);
	    enableModelButtons();
	    resetArrows();
	    rightLabel1.setVisible(false);
	    rightLabel2.setVisible(false);
	    rightLabel3.setVisible(true);
	 }
	 
	 public  void enableModelButtons() {
	    	launch.setDisable(false);
	    	stop.setDisable(false);
	    	circle1.setDisable(false);
	    	circle2.setDisable(false);
	    	circle3.setDisable(false);
	    }
	 
	 public  void resetArrows() {
	    	roundArrow1.setVisible(false);
	    	roundArrow2.setVisible(false);
	    	roundArrow3.setVisible(false);
	    }
	    
	 public  void ArrowSphere2() {
	    	roundArrow1.setVisible(true);
	    	roundArrow2.setVisible(true);
	    }
	    
	 public  void ArrowSphere3() {
	    	roundArrow1.setVisible(true);
	    	roundArrow2.setVisible(true);
	    	roundArrow3.setVisible(true);
	    }
	   
	 public  void disableRightLabels() {
	    	rightLabel1.setVisible(false);
	    	rightLabel2.setVisible(false);
	    	rightLabel3.setVisible(false);
	    }
	    
	 public  void disableModelButtons() {
	    	launch.setDisable(true);
	    	stop.setDisable(true);
	    	circle1.setDisable(true);
	    	circle2.setDisable(true);
	    	circle3.setDisable(true);
	    }
	    
	 public  void resetTask() {
	    	taskText.clear();
	    	firstTask.clear();
	    	secondTask.clear();
	    	thirdTask.clear();
	    	fourthTask.clear();
	    	checkA.setSelected(false);
	    	checkB.setSelected(false);
	    	checkC.setSelected(false);
	    	checkD.setSelected(false);
	    	startTask.setDisable(true);
	    	newQuestion.setDisable(true);
	    	ready.setDisable(false);
	    }
	
	 public  void unCheck() {
	    	checkAAnswer.setSelected(false);
	    	checkBAnswer.setSelected(false);
	    	checkCAnswer.setSelected(false);
	    	checkDAnswer.setSelected(false);
	    }
	    
	 public  void resetMarksAnswers() {
	    	AGreen.setVisible(false);
	    	BGreen.setVisible(false);
	    	CGreen.setVisible(false);
	    	DGreen.setVisible(false);
	    	ARed.setVisible(false);
	    	BRed.setVisible(false);
	    	CRed.setVisible(false);
	    	DRed.setVisible(false);
	    }
	    
	 public  void resetAnswer() {
	    	resetMarksAnswers();
	    	unCheck();
	    	taskTextAnswer.clear();
	    	firstTaskAnswer.clear();
	    	secondTaskAnswer.clear();
	    	thirdTaskAnswer.clear();
	    	fourthTaskAnswer.clear();
	    	stopAnswer.setVisible(false);
	    	nextQuestion.setDisable(true);
	    	checkAnswer.setDisable(false);
	    }
	    
	 public  void startAnswerAction() {
	    	theoryBtn.setDisable(true);
	    	ToModel.setDisable(true);
	    	taskBtn.setDisable(true);
	    }
	    
	 public  void endAnswerAction() {
	    	message.setVisible(false);
	    	ToModel.setDisable(false);
	    	theoryBtn.setDisable(false);
	    	taskBtn.setDisable(false);
	    }
    
	
	 
    int RAMcount = 0;
    long MemoryUsed = 0;
    long AverageMemoryUsed = 0;
    long MaxMemory = 0;
    long CurrentMemory = 0;
    private void MemoryUsage() {
    	 Runnable memoryMonitor = () -> {
             MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
             while (true) {
            	 try {
                 MemoryUsage memoryUsage = memoryMXBean.getHeapMemoryUsage();
                 RAMcount++;
                 CurrentMemory = memoryUsage.getUsed();
                 MemoryUsed = MemoryUsed + CurrentMemory;
                 if (CurrentMemory > MaxMemory) {
                     MaxMemory = CurrentMemory;
                 }
                 Thread.sleep(1000);
            	 } catch (InterruptedException e) {
					e.printStackTrace();
					Thread.currentThread().interrupt();
                    break;
				}
             }
         };
         Thread memoryMonitorThread = new Thread(memoryMonitor);
         memoryMonitorThread.setDaemon(true);
         memoryMonitorThread.start();
    }
    
    private void PrintAverageUsedRAM() {
    	AverageMemoryUsed = MemoryUsed/RAMcount;
    	System.out.println("Average RAM usage: " + AverageMemoryUsed);
    	System.out.println("Max RAM usage: " + MaxMemory);
    }
    
    
    int CPUcount = 0;
    double CPUusage = 0.0;
    double AverageCPUusage = 0.0;
    private void CPUusage() {
        Runnable cpuMonitoringTask = () -> {
            while (true) {
            	try {
                OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean();
                com.sun.management.OperatingSystemMXBean sunOsBean = (com.sun.management.OperatingSystemMXBean) osBean;
                double CpuLoad = sunOsBean.getProcessCpuLoad() * 100;
                CPUcount++;
                CPUusage = CPUusage + CpuLoad;
                Thread.sleep(1000);
                } catch (InterruptedException e) {
                	e.printStackTrace();
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        };
        Thread cpuMonitoringThread = new Thread(cpuMonitoringTask);
        cpuMonitoringThread.setDaemon(true);
        cpuMonitoringThread.start();
    }
    
    private void PrintAverageCPUusage() {
    	AverageCPUusage = CPUusage/CPUcount;
    	System.out.println("Average CPU usage: " + AverageCPUusage);
    }
    
}
