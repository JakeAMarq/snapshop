/*
 * TCSS 305
 * Assignment 3 - RoadRage
 */

package gui;

import filters.EdgeDetectFilter;
import filters.EdgeHighlightFilter;
import filters.FlipHorizontalFilter;
import filters.FlipVerticalFilter;
import filters.GrayscaleFilter;
import filters.SharpenFilter;
import filters.SoftenFilter;
import image.PixelImage;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



/**
 * SnapShop GUI.
 * 
 * @author Jacob Marquardt
 * @version 11/3/2018
 */
public class SnapShopGUI implements ActionListener {
    
    /**
     * The text of the Edge Detect button.
     */
    private static final String EDGE_DETECT_BUTTON_TEXT = "Edge Detect";
    
    /**
     * The text of the Edge Highlight button.
     */
    private static final String EDGE_HIGHLIGHT_BUTTON_TEXT = "Edge Highlight";
    
    /**
     * The text of the Flip Horizontal button.
     */
    private static final String FLIP_HORIZONTAL_BUTTON_TEXT = "Flip Horizontal";
    
    /**
     * The text of the Flip Vertical button.
     */
    private static final String FLIP_VERTICAL_BUTTON_TEXT = "Flip Vertical";
    
    /**
     * The text of the Grayscale button.
     */
    private static final String GRAYSCALE_BUTTON_TEXT = "Grayscale";
    
    /**
     * The text of the Sharpen button.
     */
    private static final String SHARPEN_BUTTON_TEXT = "Sharpen";
    
    /**
     * The text of the Soften button.
     */
    private static final String SOFTEN_BUTTON_TEXT = "Soften";
    
    /**
     * The text of the Open button.
     */
    private static final String OPEN_BUTTON_TEXT = "Open...";
    
    /**
     * The text of the Save As button.
     */
    private static final String SAVE_AS_BUTTON_TEXT = "Save as...";
    
    /**
     * The text of the Close Image button.
     */
    private static final String CLOSE_IMAGE_BUTTON_TEXT = "Close Image";
    
    /**
     * The error message thrown when an invalid file is chosen.
     */
    private static final String ERROR_MESSAGE = "The selected file did not contain an image!";
    
    /**
     * Title of error message thrown when an invalid file is chosen.
     */
    private static final String ERROR_TITLE = "Error!";
    
    /**
     * the EdgeDetect filter.
     */
    private EdgeDetectFilter myEdgeDetect;
    
    /**
     * the Edge Highlight filter.
     */
    private EdgeHighlightFilter myEdgeHighlight;
    
    /**
     * the Flip Horizontal filter.
     */
    private FlipHorizontalFilter myFlipHorizontal;
    
    /**
     * the Flip Vertical filter.
     */
    private FlipVerticalFilter myFlipVertical;
    
    /**
     * the Grayscale filter.
     */
    private GrayscaleFilter myGrayscale;
    
    /**
     * the Sharpen filter.
     */
    private SharpenFilter mySharpen;
    
    /**
     * the Soften filter.
     */
    private SoftenFilter mySoften;
    
    /**
     * The file chooser used to open and save files.
     */
    private JFileChooser myFileChooser;
    
    /**
     * The frame which the whole GUI is placed in.
     */
    private JFrame myFrame;
    
    /**
     * the Edge Detect button.
     */
    private JButton myEdgeDetectButton;
    
    /**
     * the Edge Highlight button.
     */
    private JButton myEdgeHighlightButton;
    
    /**
     * the Flip Horizontal button.
     */
    private JButton myFlipHorizontalButton;
    
    /**
     * the Flip Vertical button.
     */
    private JButton myFlipVerticalButton;
    
    /**
     * the Grayscale button.
     */
    private JButton myGrayscaleButton;
    
    /**
     * the Sharpen button.
     */
    private JButton mySharpenButton;
    
    /**
     * the Soften button.
     */
    private JButton mySoftenButton;
    
    /**
     * the Open... button.
     */
    private JButton myOpenButton;
    
    /**
     * The Save As... button.
     */
    private JButton mySaveAsButton;
    
    /**
     * The Close Image button.
     */
    private JButton myCloseImageButton;
    
    /**
     * PixelImage used to set myLabel's icon to display image.
     */
    private PixelImage myPic;
    
    /**
     * JLabel used to display image.
     */
    private final JLabel myLabel;
       
    /**
     * Constructor for GUI.
     */
    public SnapShopGUI() {
        myFrame = new JFrame();
        myFileChooser = new JFileChooser();
        myFileChooser.setCurrentDirectory(new File("."));
        myLabel = new JLabel();
        myLabel.setHorizontalAlignment(JLabel.CENTER);
        constructFilters();
        constructButtons();        
        setButtonListeners();
        setButtonsEnabled(false);    
    }
    
    /**
     * Constructs the filters.
     */
    private void constructFilters() {
        myEdgeDetect = new EdgeDetectFilter();
        myEdgeHighlight = new EdgeHighlightFilter();
        myFlipHorizontal = new FlipHorizontalFilter();
        myFlipVertical = new FlipVerticalFilter();
        myGrayscale = new GrayscaleFilter();
        mySharpen = new SharpenFilter();
        mySoften = new SoftenFilter();
    }
    
    /**
     * Constructs the buttons.
     */
    private void constructButtons() {
        myEdgeDetectButton = new JButton(EDGE_DETECT_BUTTON_TEXT);
        myEdgeHighlightButton = new JButton(EDGE_HIGHLIGHT_BUTTON_TEXT);
        myFlipHorizontalButton = new JButton(FLIP_HORIZONTAL_BUTTON_TEXT);
        myFlipVerticalButton = new JButton(FLIP_VERTICAL_BUTTON_TEXT);
        myGrayscaleButton = new JButton(GRAYSCALE_BUTTON_TEXT);
        mySharpenButton = new JButton(SHARPEN_BUTTON_TEXT);
        mySoftenButton = new JButton(SOFTEN_BUTTON_TEXT);
        myOpenButton = new JButton(OPEN_BUTTON_TEXT);
        mySaveAsButton = new JButton(SAVE_AS_BUTTON_TEXT);
        myCloseImageButton = new JButton(CLOSE_IMAGE_BUTTON_TEXT);
    }
    
    /**
     * Adds actionListener to all buttons.
     */
    private void setButtonListeners() {
        myEdgeDetectButton.addActionListener(this);
        myEdgeHighlightButton.addActionListener(this);
        myFlipHorizontalButton.addActionListener(this);
        myFlipVerticalButton.addActionListener(this);
        myGrayscaleButton.addActionListener(this);
        mySharpenButton.addActionListener(this);
        mySoftenButton.addActionListener(this);
        myOpenButton.addActionListener(this);
        mySaveAsButton.addActionListener(this);
        myCloseImageButton.addActionListener(this);
    }
    
    /**
     * Enables or disables all buttons excluding the Open... button.
     * 
     * @param theEnabled what isEnabled will be set to for each button
     */
    private void setButtonsEnabled(final boolean theEnabled) {
        myEdgeDetectButton.setEnabled(theEnabled);
        myEdgeHighlightButton.setEnabled(theEnabled);
        myFlipHorizontalButton.setEnabled(theEnabled);
        myFlipVerticalButton.setEnabled(theEnabled);
        myGrayscaleButton.setEnabled(theEnabled);
        mySharpenButton.setEnabled(theEnabled);
        mySoftenButton.setEnabled(theEnabled);
        mySaveAsButton.setEnabled(theEnabled);
        myCloseImageButton.setEnabled(theEnabled);
    }
    
    /**
     * Creates the GUI and makes it visible to the user.
     */
    public void start() {
        myFrame.setTitle("SnapShop");
        myFrame.setLayout(new BorderLayout());
        myFrame.add(makeNorthButtons(), BorderLayout.NORTH);
        myFrame.add(myLabel, BorderLayout.CENTER);
        myFrame.add(makeSouthButtons(), BorderLayout.SOUTH);
        myFrame.pack();
        myFrame.setMinimumSize(myFrame.getSize());
        myFrame.setVisible(true);
    }
    
    /**
     * Returns a JPanel containing the top buttons.
     * 
     * @return a JPanel containing the top buttons
     */
    private JPanel makeNorthButtons() {
        final JPanel northButtons = new JPanel(new FlowLayout());
        northButtons.add(myEdgeDetectButton);
        northButtons.add(myEdgeHighlightButton);
        northButtons.add(myFlipHorizontalButton);
        northButtons.add(myFlipVerticalButton);
        northButtons.add(myGrayscaleButton);
        northButtons.add(mySharpenButton);
        northButtons.add(mySoftenButton);
        return northButtons;
    }
    
    /**
     * Returns a JPanel containing the bottom buttons.
     * 
     * @return a JPanel containing the bottom buttons
     */
    private JPanel makeSouthButtons() {
        final JPanel southButtons = new JPanel(new FlowLayout());
        southButtons.add(myOpenButton);
        southButtons.add(mySaveAsButton);
        southButtons.add(myCloseImageButton);
        return southButtons;
    }

    /**
     * Method that gets called when a button is pressed and carries and
     * out action of that button.
     * 
     * I chose to ignore the warned of my cyclomatic complexity being too
     * high in this method because the method is clear and manageable.
     * 
     * @param theEvent the button being pressed
     */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        final int result;
        switch (theEvent.getActionCommand()) {
            case OPEN_BUTTON_TEXT:
                result = myFileChooser.showOpenDialog(myOpenButton);
                if (result == JFileChooser.APPROVE_OPTION) {
                    try {
                        myPic = PixelImage.load(myFileChooser.getSelectedFile());
                        myLabel.setIcon(new ImageIcon(myPic));       
                        setButtonsEnabled(true);
                    } catch (final IOException e) {
                        JOptionPane.showMessageDialog(null, 
                                                      ERROR_MESSAGE, 
                                                      ERROR_TITLE, 
                                                      JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                break;
            case SAVE_AS_BUTTON_TEXT:
                result = myFileChooser.showOpenDialog(myOpenButton);
                if (result == JFileChooser.APPROVE_OPTION) {
                    try {
                        myPic.save(myFileChooser.getSelectedFile());
                    } catch (final IOException e) { }
                }
                break;
            case CLOSE_IMAGE_BUTTON_TEXT:
                myLabel.setIcon(null);
                setButtonsEnabled(false);
                myFrame.setMinimumSize(null);
                break;
            case EDGE_DETECT_BUTTON_TEXT:
                myEdgeDetect.filter(myPic);
                myLabel.setIcon(new ImageIcon(myPic));
                break;
            case EDGE_HIGHLIGHT_BUTTON_TEXT:
                myEdgeHighlight.filter(myPic);
                myLabel.setIcon(new ImageIcon(myPic));
                break;
            case FLIP_HORIZONTAL_BUTTON_TEXT:
                myFlipHorizontal.filter(myPic);
                myLabel.setIcon(new ImageIcon(myPic));
                break;
            case FLIP_VERTICAL_BUTTON_TEXT:
                myFlipVertical.filter(myPic);
                myLabel.setIcon(new ImageIcon(myPic));
                break;
            case GRAYSCALE_BUTTON_TEXT:
                myGrayscale.filter(myPic);
                myLabel.setIcon(new ImageIcon(myPic));
                break;
            case SHARPEN_BUTTON_TEXT:
                mySharpen.filter(myPic);
                myLabel.setIcon(new ImageIcon(myPic));
                break;
            case SOFTEN_BUTTON_TEXT:
                mySoften.filter(myPic);
                myLabel.setIcon(new ImageIcon(myPic));
                break;
            default:
                break;
        }
        myFrame.pack();
        myFrame.setMinimumSize(myFrame.getSize());
    }
}