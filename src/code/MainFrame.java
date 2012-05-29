package code;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MainFrame extends AbstractFrame{
    private JPanel leftPanel,rightPanel,titlePanel,testAllPanel,lessonPanel,buttonPanel,lessons;
    private JScrollPane lessonScrollPanel;
    private JButton logoutButton,testAllButton,addLessonButton,deleteLessonButton;
    private JLabel titleLabel;
    private int sum_lesson;

    public MainFrame(){
	super("resource/MainFrame.png");
	sum_lesson=0;
	initMainFrameLayout();
	initPanel();
	initTitlePanel();
	initLessonScrollPanel();
	initLessonPanel();
	initTestAllPanel();
    }

    /**
     * @return the logoutButton
     */
    public JButton getLogoutButton() {
        return logoutButton;
    }

    /**
     * @return the testAllButton
     */
    public JButton getTestAllButton() {
        return testAllButton;
    }

    /**
     * @return the addLessonButton
     */
    public JButton getAddLessonButton() {
        return addLessonButton;
    }

    /**
     * @return the deleteLessonButton
     */
    public JButton getDeleteLessonButton() {
        return deleteLessonButton;
    }

    private void initMainFrameLayout(){
	getMainPanel().setLayout(new GridLayout(1,2));
    }

    private void initPanel(){
	leftPanel = new JPanel();
	leftPanel.setLayout(new BorderLayout());
	rightPanel = new JPanel();
	rightPanel.setOpaque(false);
	getMainPanel().add(leftPanel);
	getMainPanel().add(rightPanel);
    }

    private void initTitlePanel(){

	logoutButton = new JButton(new ImageIcon("resource/LogoutButton.PNG"));
	logoutButton.setBackground(new Color(0,0,0,0));
	titleLabel = new JLabel("English Tutor");

	titlePanel = new JPanel();
	titlePanel.setLayout(new GridLayout(1,4));
	titlePanel.setOpaque(false);
	leftPanel.setOpaque(false);
	titlePanel.add(logoutButton);
	titlePanel.add(new JLabel());
	titlePanel.add(titleLabel);
	titlePanel.add(new JLabel());
	leftPanel.add(titlePanel,BorderLayout.NORTH);
    }

    private void initLessonScrollPanel(){
	lessonScrollPanel = new JScrollPane();
	lessonScrollPanel.setVisible(true);
	lessonScrollPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	lessonScrollPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	leftPanel.add(lessonScrollPanel,BorderLayout.CENTER);
    }

    private void initLessonPanel(){
	lessons = new JPanel();
	lessonPanel = new JPanel();
	lessonPanel.setLayout(new BorderLayout());

	buttonPanel = new JPanel();
	buttonPanel.setLayout(new GridLayout(1,5));

	addLessonButton = new JButton("add");
	deleteLessonButton = new JButton("delete");

	buttonPanel.add(addLessonButton);
	buttonPanel.add(deleteLessonButton);
	buttonPanel.add(new JLabel());
	buttonPanel.add(new JLabel());
	buttonPanel.add(new JLabel());

	lessonPanel.add(lessons,BorderLayout.CENTER);
	lessonPanel.add(buttonPanel,BorderLayout.SOUTH);
	lessonScrollPanel.setViewportView(lessonPanel);
    }


    private void initTestAllPanel(){
	testAllPanel = new JPanel();
	testAllPanel.setOpaque(false);
	testAllPanel.setLayout(new GridLayout(2,5));
	testAllPanel.add(new JLabel());
	testAllPanel.add(new JLabel());
	testAllButton = new JButton("Test All");
	testAllPanel.add(testAllButton);
	testAllPanel.add(new JLabel());
	testAllPanel.add(new JLabel());
	testAllPanel.add(new JLabel());
	testAllPanel.add(new JLabel());
	testAllPanel.add(new JLabel());
	testAllPanel.add(new JLabel());
	testAllPanel.add(new JLabel());
	leftPanel.add(testAllPanel,BorderLayout.SOUTH);
    }

    public void addLesson(String lessonName){
	sum_lesson++;
	LessonItemPanel newLesson = new LessonItemPanel(lessonName);
	lessons.setLayout(new GridLayout(sum_lesson,1));
	lessons.add(newLesson);
    }

    public void deleteLesson(String lessonName){

    }

    private class LessonItemPanel extends JPanel{
	private JLabel lockLabel,lessonNameLabel,smileLabel;

	private LessonItemPanel(String lessonName) {
	    super();
	    setLayout(new GridLayout(1,5));
	    lockLabel = new JLabel(new ImageIcon("resource/LockLabel.png"));
	    lessonNameLabel  = new JLabel(lessonName);
	    smileLabel = new JLabel(new ImageIcon("resource/SmileLabel.png"));
	    //smileLabel.setVisible(false);

	    add(lockLabel);
	    add(new JLabel());
	    add(lessonNameLabel);
	    add(new JLabel());
	    add(smileLabel);
	}

	public void setLearnedStatue(){
	    lockLabel.setVisible(false);
	    smileLabel.setVisible(true);
	}
    }

}