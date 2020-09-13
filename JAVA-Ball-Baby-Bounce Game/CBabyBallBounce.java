//imports javax.swing.JPanel
import javax.swing.JPanel;
// imports java.awt.*;
import java.awt.*;
// imports javax.swing.border.EmptyBorder;
import javax.swing.border.EmptyBorder;
// imports javax.swing.border.LineBorder;
import javax.swing.border.LineBorder;
// imports javax.swing.event.*;
import javax.swing.event.*;
// imports javax.swing
import javax.swing.*;
//imports java.awt.event.*;
import java.awt.event.*;
// imports java.util.*;
import java.util.*;
// imports java.util.timer
import java.util.Timer;
// imports java.util.timertask
import java.util.TimerTask;
// imports java.util.timeUnit
import java.util.concurrent.TimeUnit;
// imports java.lang.*
import java.lang.*;
// imports java.awt.evene.*
import java.awt.event.*;

// Initialises the class CBabyBallBounce and extends JFame while implementing ActionListener and MouseInputListener
public class CBabyBallBounce extends JFrame implements ActionListener, MouseInputListener {
	//
	// initialises the serial version
	private static final long serialVersionUID = 1L;
	// for
	// initialises JPanel contentPane
	private final JPanel contentPane;
	// initialises JPanel panelMap
	final JPanel panelMap = new JPanel();
	// initialises JPanel panelGame
	final JPanel panelGame = new JPanel();
	// initialises JPanel panelMain
	final JPanel panelMain = new JPanel();
	// initialises JPanel panelMouse
	JPanel panelMouse = new JPanel();

	// initialises JTextField
	// initialises JTextField squareBox
	private final JTextField squareBox = new JTextField();
	// initialises JTextField directionBox
	private final JTextField directionBox = new JTextField();
	// initialises JTextField optionBox
	private final JTextField optionBox = new JTextField();
	// initialises JTextField timerHour
	private final JTextField timerHour = new JTextField();
	// initialises JTextField timerMin
	private final JTextField timerMin = new JTextField();
	// initialises JTextField timerSec
	private final JTextField timerSec = new JTextField();
	// initialises JTextField scoreLeft
	private final JTextField scoreLeft = new JTextField();
	// initialises JTextField scoreRight
	private final JTextField scoreRight = new JTextField();

	// initialises JButton
	// initialises JButton btnUp
	final JButton btnUp = new JButton("^");
	// initialises JButton btnBall
	final JButton btnBall = new JButton("");
	// initialises JButton btnDown
	final JButton btnDown = new JButton("v");
	// initialises JButton btnRight
	final JButton btnRight = new JButton(">");
	// initialises JButton btnLeft
	final JButton btnLeft = new JButton("<");
	// initialises JButton btnMap
	final JButton btnMap = new JButton("");
	// initialises JButton btnTwoPlayers
	final JButton btnTwoPlayers = new JButton("2 Player");
	// initialises JButton btnFourPlayers
	final JButton btnFourPlayers = new JButton("4 Player");
	// initialises JButton btnMulti
	final JButton btnMulti = new JButton("Multi");
	// initialises JButton btnExit
	final JButton btnExit = new JButton("Exit");
	// initialises JButton btnAct
	final JButton btnAct = new JButton("Act");
	// initialises JButton btnRun
	final JButton btnRun = new JButton("Run");
	// initialises JButton btnReset
	final JButton btnReset = new JButton("Reset");
	// Created an array grid[][] of size [13][16]
	JButton grid[][] = new JButton[13][16];
	// initialises integer
	// creates integer lR, lC, rR, rC, bR, bC, lTR = 3, lTC = 3
	int lR, lC, rR, rC, bR, bC, lTR = 3, lTC = 3;
	// creates integer rTC = 13, rTR = 6
	int rTC = 13, rTR = 6;
	// creates integer rBR = 6, rBC = 11, speed = 1, scoreL, scoreR
	int rBR = 6, rBC = 11, speed = 1, scoreL, scoreR;
	// creates integer lY = 1, lYS = 1, rY, timeM, timeH
	int lY = 1, lYS = 1, rY, timeM, timeH;
	// creates integer vSpeedlT = -1, vSpeedrT = 1, vSpeedrB = -1
	int vSpeedlT = -1, vSpeedrT = 1, vSpeedrB = -1;
	// creates integer vDirection = 1
	int vDirection = 1;
	// Initialises float timeS
	float timeS;
	// Initialises timer tt
	javax.swing.Timer tt = new javax.swing.Timer(100, this);
	// initialises boolean four as false
	boolean four = false;
	// initialises Timer timer
	Timer timer = new Timer();

	public static void main(final String[] args) {
		// inherits CBabyBallBounce to variable frame
		final CBabyBallBounce frame = new CBabyBallBounce();
		// sets setResizable of frame to false
		frame.setResizable(false);
		// sets setLocationRelative of frame to null
		frame.setLocationRelativeTo(null);
		// sets setDefaultCloseOperation of frame to WindowConstants.EXIT_ON_CLOSE
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		// sets setVisible of frame to true
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(final ActionEvent e) {
		// checks if "left:" eqals "right"
		// checks if e.getSource() equals btnBall
		// checks if e.getSource() equals btnBall
		if (e.getSource().equals(btnBall)) {
			// sets setIcon of grid[bR][bC] to null
			grid[bR][bC].setIcon(null);
			// calls function ball()
			ball();
			// sets speed to 1
			speed = 1;

		}
		// checks if e.getSource() is equal to btnAct
		if (e.getSource().equals(btnAct)) {
			// checks if ((bR == rR) && ((rC - 1) == bC))
			if (((bR == rR) && ((rC - 1) == bC))) {
				// reverses the direction of speed
				speed = -speed;
				// sets setText of directionBox to WEST
				directionBox.setText("WEST");
				// sets setIcon of btnMap to west.jpg
				btnMap.setIcon(new ImageIcon("images\\west.jpg"));
			}
			// checks if (((bR == lR) && ((lC + 1) == bC)))
			if ((((bR == lR) && ((lC + 1) == bC)))) {
				// reverses the direction of speed
				speed = -speed;
				// sets setText of directionBox to EAST
				directionBox.setText("EAST");
				// sets setIcon of btnMap to east.jpg
				btnMap.setIcon(new ImageIcon("images\\east.jpg"));
			}
			// ckecks if bC equals 0
			if ((bC == 0)) {
				// reverses the direction of speed
				speed = -speed;
				// increases scoreR by 1
				scoreR += 1;
				// sets setText of scoreRight to scoreR
				scoreRight.setText("" + scoreR);
				// sets setIcon of btnMap to east.jpg
				btnMap.setIcon(new ImageIcon("images\\east.jpg"));
				// sets setText of directionBox to EAST
				directionBox.setText("EAST");

			} else if (bC == 15) {
				// reverses the direction of speed
				speed = -speed;
				// increases scoreL by 1
				scoreL += 1;
				// sets setText of scoreLeft to scoreL
				scoreLeft.setText("" + scoreL);
				// sets setIcon of btnMap to west.jpg
				btnMap.setIcon(new ImageIcon("images\\west.jpg"));
				// sets setText of directionBox to WEST
				directionBox.setText("WEST");

			}
			// sets grid[bR][bC] to null
			grid[bR][bC].setIcon(null);
			// bC increases by speed
			bC += speed;
			// sets setIcon of grid[bR][bC] to ball.png
			grid[bR][bC].setIcon(new ImageIcon("images\\ball.png"));
			// sets setText of squareBox to ((bC + 1) * (bR + 1))
			squareBox.setText("" + ((bC + 1) * (bR + 1)));

			if (speed == 1 && (bC == 8 || bC == 9)) {
				// sets setIcon of grid[bR][bC - 1] to wall.png
				grid[bR][bC - 1].setIcon(new ImageIcon("images\\wall.png"));

			} else if (speed == -1 && (bC == 7 || bC == 6)) {
				// sets setIcon of grid[bR][bC + 1] to wall.png
				grid[bR][bC + 1].setIcon(new ImageIcon("images\\wall.png"));
			}
		}
		// checks if e.getSource() is equal to btnRun
		if (e.getSource().equals(btnRun)) {
			// sets schedule to timer
			timer.schedule(new TimerTask() {

				@Override
				// runs the function
				public void run() {
					// sets the loop to continuous
					while (true) {
						// starts the timer
						tt.start();
						// call function clock
						clock();
						// sets setText of timerSec to timeS
						timerSec.setText("" + timeS);
						// sets the textbox of optionBox to "4 PLYR"
						optionBox.setText("4 PLYR");
						// checks if timeS equals 60
						if (timeS == 60) {
							// sets timeM to timeS / 60
							timeM = (int) timeS / 60;
							// sets timeS to 0
							timeS = 0;
						}
						// checks if timeM equals to 60
						if (timeM == 60) {
							// sets timeH to timeM / 60
							timeH = timeM / 60;
							// sets timeM to 0
							timeM = 0;
						}
						// sets rR to 0
						rR = 0;
						// sets rC to 0
						rC = 0;
						// sets setText of timerHour to timeH
						timerHour.setText("" + timeH);
						// sets setText of timerMin to timtM
						timerMin.setText("" + timeM);
						// checks if rTR equals to 0
						if (rTR == 0) {
							// reverses the direction of vSpeedrT
							vSpeedrT = -vSpeedrT;

						}
						// checks if rTR equals to 12
						if (rTR == 12) {
							// reverses the direction of vSpeedrT
							vSpeedrT = -vSpeedrT;

						}
						// sets setIcon of grid[rTR][rTC] to null
						grid[rTR][rTC].setIcon(null);
						// increases rTR by vSpeedrT
						rTR += vSpeedrT;
						// sets setIcon of grid[rTR][rTC] to baby2.png
						grid[rTR][rTC].setIcon(new ImageIcon("images\\baby2.png"));
						// checks if LTR equals to 0
						if (lTR == 0) {
							// reverses the direction of vSpeedlT
							vSpeedlT = -vSpeedlT;

						}
						// checks if LTR equals to 12
						if (lTR == 12) {
							// reverses the direction of vSpeedLT
							vSpeedlT = -vSpeedlT;

						}
						// sets setIcon of grid[lTR][lTC] to null
						grid[lTR][lTC].setIcon(null);
						// increases LTR by vSpeedlT
						lTR += vSpeedlT;
						// sets setIcon of grid[lTR][lTC] to baby1.png
						grid[lTR][lTC].setIcon(new ImageIcon("images\\baby1.png"));
						// checks if rBR equals to 0
						if (rBR == 0) {
							// reverses the direction of vSpeedrB
							vSpeedrB = -vSpeedrB;

						}
						// checks if rBR equals to 12
						if (rBR == 12) {
							// reverses the direction of vSpeedrB
							vSpeedrB = -vSpeedrB;

						}
						// sets grid[rBR][rBC] to null
						grid[rBR][rBC].setIcon(null);
						// increases the value of rBR by vSpeedrB
						rBR += vSpeedrB;
						// sets grid[rBR][rBC] to baby2.jpg
						grid[rBR][rBC].setIcon(new ImageIcon("images\\baby2.png"));
						// sets mouseMotionListener in the panel panelMouse
						panelMouse.addMouseMotionListener(new MouseMotionListener() {

							@Override
							public void mouseDragged(final MouseEvent e) {

							}

							@Override
							public void mouseMoved(final MouseEvent e) {
								// initialises integer l
								int l;
								// sets lY to the vertical location of ball divided by 30
								lY = (e.getY()) / 30;
								// sets value of l to lY
								l = lY;
								// sets value of lR to l
								lR = l;

								// sets grid[l][c] to baby1.png
								grid[l][lC].setIcon(new ImageIcon("images\\baby1.png"));
								// loops i to 13th step
								for (int i = 0; i < 13; i++) {
									// checks if i is not equal to l
									if (i != l) {
										// sets grid[l][c] to null
										grid[i][lC].setIcon(null);
									}
								}

							}

						});
						// checks if ((((bR == (rBR + 1)) || ((bR == (rBR - 1)))) && ((rBC - 1) == bC)))
						if ((((bR == (rBR + 1)) || ((bR == (rBR - 1)))) && ((rBC - 1) == bC))) {
							// sets the direction of speed to opposite
							speed = -speed;
							// sets setText of directionBox to "WEST"
							directionBox.setText("WEST");
							// sets icon of btnMap to west.jpg
							btnMap.setIcon(new ImageIcon("images\\west.jpg"));
						}
						// checks if (((bR == (rTR + 1)) || ((bR == (rTR + 1)))) && ((rTC - 1) == bC))
						if (((bR == (rTR + 1)) || ((bR == (rTR + 1)))) && ((rTC - 1) == bC)) {
							// sets the direction of speed to opposite
							speed = -speed;
							// sets setText of directionBox to "WEST"
							directionBox.setText("WEST");
							// sets icon of btnMap to west.jpg
							btnMap.setIcon(new ImageIcon("images\\west.jpg"));
						}
						// checks if ((((bR == (lR + 1)) || ((bR == (lR - 1)))) && ((lC + 1) == bC)))
						if ((((bR == (lR + 1)) || ((bR == (lR - 1)))) && ((lC + 1) == bC))) {
							// sets the direction of speed to opposite
							speed = -speed;
							// sets setText of directionBox to "EAST"
							directionBox.setText("EAST");
							// sets icon of btnMap to east.jpg
							btnMap.setIcon(new ImageIcon("images\\east.jpg"));
						}
						// checks if ((((bR == (lTR + 1)) || (bR == (lTR - 1)) && ((lTC + 1) == bC))))
						if ((((bR == (lTR + 1)) || (bR == (lTR - 1)) && ((lTC + 1) == bC)))) {
							// sets the direction of speed to opposite
							speed = -speed;
							// sets setText of directionBox to "EAST"
							directionBox.setText("EAST");
							// sets icon of btnMap to west.jpg
							btnMap.setIcon(new ImageIcon("images\\east.jpg"));
						}
						// checks if bC equals to 0
						if ((bC == 0)) {
							// sets the speed to 0
							speed = 0;
							// increases scoreR by 1
							scoreR += 1;
							// sets the text in scoreRight to scoreR
							scoreRight.setText("" + scoreR);
							// sets setText of directionBox to "EAST"
							btnMap.setIcon(new ImageIcon("images\\east.jpg"));
							// sets the text in directionBox to EAST
							directionBox.setText("EAST");
							// checks if speed is equal to 0
							if (speed == 0)
								// breaks the loop
								break;

						}
						// checks if bC equals 15
						else if (bC == 15) {
							// sets speed to 0
							speed = 0;
							// increases scoreL by 1
							scoreL += 1;
							// sets the text of scoreLeft to scoreL
							scoreLeft.setText("" + scoreL);
							// sets the icon of btnMap to west.jpg
							btnMap.setIcon(new ImageIcon("images\\west.jpg"));
							// sets the text of directionBox to WEST
							directionBox.setText("WEST");
							// checks if speed equals 0
							if (speed == 0)
								// breaks the loop
								break;
						}
						// checks if bR equals 12 or 0
						if (bR == 12 || bR == 0) {
							// reverses the direction of vDirection
							vDirection = -vDirection;
						}
						// sets the icon of array grid to null
						grid[bR][bC].setIcon(null);
						// increases the value of bC by speed
						bC += speed;
						// increases the value of bR by direction
						bR += vDirection;
						// sets the icon of grid[ball] to ball.jpg
						grid[bR][bC].setIcon(new ImageIcon("images\\ball.png"));
						// sets text to multiplication of rows and columns
						squareBox.setText("" + ((bC + 1) * (bR + 1)));
						{
							// checks if speed equals to 1 and bC equals 8 or 9
							if (speed == 1 && (bC == 8 || bC == 9)) {
								// checks if bR equals12
								if (bR == 12) {
									// sets the grid to wall.png
									grid[bR - 1][bC - 1].setIcon(new ImageIcon("images\\wall.png"));
								}
								// checks if bR euqls 0
								else if (bR == 0) {
									// sets the grid to wall.png
									grid[bR + 1][bC - 1].setIcon(new ImageIcon("images\\wall.png"));
								} else {
									// sets the grid to wall.png
									grid[bR + 1][bC - 1].setIcon(new ImageIcon("images\\wall.png"));
									// sets the grid to wall.png
									grid[bR - 1][bC - 1].setIcon(new ImageIcon("images\\wall.png"));
								}
							}
							// checks if(speed == -1 && (bC == 7 || bC == 6))
							else if (speed == -1 && (bC == 7 || bC == 6)) {
								// checks if bR equals 12
								if (bR == 12) {
									// sets the grid to wall.png
									grid[bR - 1][bC + 1].setIcon(new ImageIcon("images\\wall.png"));
								}
								// checks if bR equals 0
								else if (bR == 0) {
									// sets the grid to wall.png
									grid[bR + 1][bC + 1].setIcon(new ImageIcon("images\\wall.png"));
								} else {
									// sets the grid to wall.png
									grid[bR + 1][bC + 1].setIcon(new ImageIcon("images\\wall.png"));
									// sets the grid to wall.png
									grid[bR - 1][bC + 1].setIcon(new ImageIcon("images\\wall.png"));
								}

							}
						}

					}
				}

			}, 1);

		}
		// checks if e.getSource() equals btnReset
		if (e.getSource().equals(btnReset)) {
			// sets scoreL to 0
			scoreL = 0;
			// sets scoreR to 0
			scoreR = 0;
			// sets the text of scoreLeft to scoreL
			scoreLeft.setText("" + scoreL);
			// sets the text of scoreRight to scoreR
			scoreRight.setText("" + scoreR);
			// sets the grid of ball to null
			grid[bR][bC].setIcon(null);

			// sets the grid of right player to null
			grid[rR][rC].setIcon(null);
			// sets the grid of left player to null
			grid[lR][lC].setIcon(null);

			// sets the grid of left player to null
			grid[lTR][lTC].setIcon(null);
			// sets the grid of right player to null
			grid[rTR][rTC].setIcon(null);
			// sets the grid of right player to null
			grid[rBR][rBC].setIcon(null);
			// sets timeS to 0
			timeS = 0;
			// sets timeM to 0
			timeM = 0;
			// sets timeH to 0
			timeH = 0;
			// sets text of timeHour to timeH
			timerHour.setText("" + timeH);
			// sets text of timeSex to timeS
			timerSec.setText("" + timeS);
			// sets text of timeMnin to timeM
			timerMin.setText("" + timeM);
			// calls the method players()
			players();
			// sets the text of optionBox to "2 PLYR"
			optionBox.setText("2 PLYR");
			// calls the method ball()
			ball();
			// sets the speed to 1
			speed = 1;
			// sets the text of directionBox to "EAST"
			directionBox.setText("EAST");
			// sets text to multiplication of rows and columns
			squareBox.setText("" + ((bC + 1) * (bR + 1)));
			// sets the icon of btnMap to east.jpg
			btnMap.setIcon(new ImageIcon("images\\east.jpg"));

			// loops value of i 13 times
			for (int i = 0; i <= 12; i++) {
				// loops value of j 16 times
				for (int j = 0; j <= 15; j++) {
					// checks if i is greater than 6 and smaller than 9
					if (j >= 7 && j < 9) {
						// sets the icon to wall.png
						grid[i][j].setIcon(new ImageIcon("images\\wall.png"));
					}
					// adds the grid to game panel
					panelGame.add(grid[i][j]);

				}
			}

		}
		// checks if e.getSource() equals (btnLeft) or e.getSource() equals(btnRight)
		if (e.getSource().equals(btnLeft) || e.getSource().equals(btnRight)) {
			// checks if e.getSource() equals (btnLeft) and bC != 0
			if (e.getSource().equals(btnLeft) && bC != 0) {
				// sets the grid of ball to null
				grid[bR][bC].setIcon(null);
				// decreases bC by 1
				bC = bC - 1;
				// checks if (((bR == lR) and ((lC) == bC)))
				if ((((bR == lR) && ((lC) == bC)))) {
					// increases bC by 1
					bC = bC + 1;
				}
				// sets the grid of ball to ball.png
				grid[bR][bC].setIcon(new ImageIcon("images\\ball.png"));
				// sets the icon of btnMap to west.jpg
				btnMap.setIcon(new ImageIcon("images\\west.jpg"));
				// sets the text of directionBox to "EAST"
				directionBox.setText("EAST");
				// checks if bC equals 7 or 6
				if (bC == 6 || bC == 7) {
					// sets the grid of ballto wall.png
					grid[bR][bC + 1].setIcon(new ImageIcon("images\\wall.png"));

				}
				// sets text to multiplication of rows and columns
				squareBox.setText("" + ((bC + 1) * (bR + 1)));
				// sets the text to "WEST"
				directionBox.setText("WEST");

			}
			// checks if e.getSource() equals (btnRight) and bC != 15
			if (e.getSource().equals(btnRight) && bC != 15) {
				// sets the grid of ball to null
				grid[bR][bC].setIcon(null);
				// increases bC by 1
				bC += 1;
				// checks if ((bR == rR) and ((rC) == bC))
				if (((bR == rR) && ((rC) == bC))) {
					// sets bC to -1
					bC -= 1;
				}
				// sets grid of ball to ball.png
				grid[bR][bC].setIcon(new ImageIcon("images\\ball.png"));
				// sets text to multiplication of rows and columns
				squareBox.setText("" + ((bC + 1) * (bR + 1)));
				// checks if bC equals 8 or 9
				if (bC == 8 || bC == 9) {
					// sets the grid to wall.png
					grid[bR][bC - 1].setIcon(new ImageIcon("images\\wall.png"));

				}
				// sets the icon in btnMap to east.jpg
				btnMap.setIcon(new ImageIcon("images\\east.jpg"));
				// sets the text to "EAST"
				directionBox.setText("EAST");
			}

		}
		// NOTE BUTTON UP
		// checks if e.getSource() equals (btnUP) or e.getSource() equals(btnDown)
		if (e.getSource().equals(btnUp) || e.getSource().equals(btnDown)) {
			// checks if e.getSource() equals (btnUP)
			if (e.getSource().equals(btnUp)) {
				if (bR >= 1) {
					// sets the grid of ball to null
					grid[bR][bC].setIcon(null);
					// decreases bR by 1
					bR -= 1;
					// sets the icon of btnMap to north.jpg
					btnMap.setIcon(new ImageIcon("images\\north.jpg"));
					// sets the grid of ball to ball.png
					grid[bR][bC].setIcon(new ImageIcon("images\\ball.png"));
				}
				// sets the text of directionBox to "EAST"
				directionBox.setText("NORTH");
				// sets text to multiplication of rows and columns
				squareBox.setText("" + ((bC + 1) * (bR + 1)));
			}
			// checks if e.getSource() equals (btnDown)
			if (e.getSource().equals(btnDown)) {
				// checks if bR is smaller or equals to 11
				if (bR <= 11) {
					// sets the grid of ball to null
					grid[bR][bC].setIcon(null);
					// increases bR by 1
					bR += 1;
					// sets the icon of btnMap to south.jpg
					btnMap.setIcon(new ImageIcon("images\\south.jpg"));
					// sets the grid of ball to ball.png
					grid[bR][bC].setIcon(new ImageIcon("images\\ball.png"));
				}
				// sets the text of directionBox to "SOUTH"
				directionBox.setText("SOUTH");
				// sets text to multiplication of rows and columns
				squareBox.setText("" + ((bC + 1) * (bR + 1)));

			}
			// checks if bC equals 7 or 8
			if ((bC == 8 || bC == 7)) {
				// checks if bR equals 1
				if (bR == 1) {
					// sets the location of ball to wall.png
					grid[bR + 1][bC].setIcon(new ImageIcon("images\\wall.png"));
				}
				// checks if bR equals 12
				else if (bR == 12) {
					// sets the location of ball to wall.png
					grid[bR - 1][bC].setIcon(new ImageIcon("images\\wall.png"));
				} else {
					// sets the location of ball to wall.png
					grid[bR - 1][bC].setIcon(new ImageIcon("images\\wall.png"));
					// sets the location of ball to wall.png
					grid[bR + 1][bC].setIcon(new ImageIcon("images\\wall.png"));
				}

			}
		}
		// checks if e.getSource() equals(btnFourPlayers)
		if (e.getSource().equals(btnFourPlayers)) {
			// sets the location of left player to null
			grid[lR][lC].setIcon(null);
			// sets the location of right player to null
			grid[rR][rC].setIcon(null);
			// sets the textbox of optionBox to "4 PLYR"
			optionBox.setText("4 PLYR");
			// calls playersFour() method
			playersFour();
			// sets four to true
			four = true;
		}
		if (e.getSource().equals(btnTwoPlayers)) {
			// sets the location of left player to null
			grid[lTR][lTC].setIcon(null);
			// sets the location of right player to null
			grid[rTR][rTC].setIcon(null);
			// sets the location of left player to null
			grid[lR][lC].setIcon(null);
			// sets the location of left player to null
			grid[rR][rC].setIcon(null);
			// sets the location of right player to null
			grid[rBR][rBC].setIcon(null);
			// sets the textbox of optionBox to "2 PLYR"
			optionBox.setText("2 PLYR");
			// calls the method players()
			players();
		}
		// checks if e.getSource() equals(btnExit)
		if (e.getSource().equals(btnExit)) {
			// exits the program
			System.exit(0);
		}
	}

	protected void clock() {
		// tries the following syntax
		try {
			// program sleeps for 500 milliseconds
			Thread.sleep(500);
			// increases timeS by 0.5
			timeS += 0.5;
		}
		// catches exceptions
		catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	// constructor
	public CBabyBallBounce() {
		// sets the icon image for application
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\greenfoot.jpg"));
		// sets the title of frame to "CBabyBallBounce- Baby Ball Bounce Application"
		setTitle("CBabyBallBounce \u2013 Baby Ball Bounce Application");
		// sets default close opetaion to JFrame.EXIT_ON_CLOSE
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// sets the bounds of frame to (100, 100, 825, 585)
		setBounds(100, 100, 825, 585);
		// creates JMenuBar menuBar
		final JMenuBar menuBar = new JMenuBar();
		// sets background colour to white
		menuBar.setBackground(Color.WHITE);
		// adds menuBar to menu
		setJMenuBar(menuBar);
		// creates a JMenu
		// creates a JMenumnNewMenuScenerio
		final JMenu mnNewMenuScenerio = new JMenu("Scenario");
		// sets the font to ("Segoe UI", Font.BOLD, 12)
		mnNewMenuScenerio.setFont(new Font("Segoe UI", Font.BOLD, 12));
		// adds the menu to menuBar
		menuBar.add(mnNewMenuScenerio);
		// createsa JMenuItem mntmNewMenuSceneioExit
		final JMenuItem mntmNewMenuSceneioExit = new JMenuItem("Exit");
		// adds mntmNewMenuSceneioExit to JMenu
		mnNewMenuScenerio.add(mntmNewMenuSceneioExit);
		// creates a JMenu mnNewMenuEdit
		final JMenu mnNewMenuEdit = new JMenu("Edit");
		// sets the font to ("Segoe UI", Font.BOLD, 12)
		mnNewMenuEdit.setFont(new Font("Segoe UI", Font.BOLD, 12));
		// adds the menu to menuBar
		menuBar.add(mnNewMenuEdit);
		// creates a JMenu mnNewMenuControls
		final JMenu mnNewMenuControls = new JMenu("Controls");
		// sets the font to ("Segoe UI", Font.BOLD, 12)
		mnNewMenuControls.setFont(new Font("Segoe UI", Font.BOLD, 12));
		// adds the menu to menuBar
		menuBar.add(mnNewMenuControls);
		// creates a JMenu mnNewMenuHelp
		final JMenu mnNewMenuHelp = new JMenu("Help");
		// sets the font to ("Segoe UI", Font.BOLD, 12)
		mnNewMenuHelp.setFont(new Font("Segoe UI", Font.BOLD, 12));
		// adds the menu to menuBar
		menuBar.add(mnNewMenuHelp);
		// createsa JMenuItem mntmNewMenuItemHelpHelpTopic
		final JMenuItem mntmNewMenuItemHelpHelpTopic = new JMenuItem("Help Topic");
		// adds mntmNewMenuItemHelpHelpTopic to JMenu
		mnNewMenuHelp.add(mntmNewMenuItemHelpHelpTopic);
		// createsa JMenuItem mntmNewMenuItemHelpAbout
		final JMenuItem mntmNewMenuItemHelpAbout = new JMenuItem("About");
		// adds mntmNewMenuItemHelpAbout to JMenu
		mnNewMenuHelp.add(mntmNewMenuItemHelpAbout);
		// creates a JPanel contentPane
		contentPane = new JPanel();
		// sets background colour to black
		contentPane.setBackground(Color.BLACK);
		// sets the border to (5, 5, 5, 5)
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// sets the contentPane
		setContentPane(contentPane);
		// sets the layout to null
		contentPane.setLayout(null);
		// creates a JPanel panelRight
		final JPanel panelRight = new JPanel();
		// sets background colour to CYAN
		panelRight.setBackground(Color.CYAN);
		// sets the font to Color.BLUE, 1, true
		panelRight.setBorder(new LineBorder(Color.BLUE, 1, true));
		// sets the bounds to (651, 5, 160, 465)
		panelRight.setBounds(651, 5, 160, 465);
		// adds the panel to contentPane
		contentPane.add(panelRight);
		// sets layout to null
		panelRight.setLayout(null);
		// creates a JPanel panelTimer
		final JPanel panelTimer = new JPanel();
		// sets the bounds to (3, 5, 153, 90)
		panelTimer.setBounds(3, 5, 153, 90);
		// adds the panel to panelRight
		panelRight.add(panelTimer);
		// sets layout to null
		panelTimer.setLayout(null);
		// creates a JLabel
		final JLabel lblTimer = new JLabel("DIGITAL TIMER");
		// sets the font to ("Tahoma", Font.BOLD, 10)
		lblTimer.setFont(new Font("Tahoma", Font.BOLD, 10));
		// sets the bounds to (28, 0, 94, 13)
		lblTimer.setBounds(28, 0, 94, 13);
		// adds the label to panelTimer
		panelTimer.add(lblTimer);
		// sets the foreground colour to white
		timerHour.setForeground(Color.WHITE);
		// sets the background colour to black
		timerHour.setBackground(Color.BLACK);
		// sets the text to'00'
		timerHour.setText("00");
		// sets columns to 10
		timerHour.setColumns(10);
		// sets the bounds to (4, 15, 27, 19)
		timerHour.setBounds(4, 15, 27, 19);
		// adds it to panelTimer
		panelTimer.add(timerHour);
		// sets the foreground colour to white
		timerMin.setForeground(Color.WHITE);
		// sets the background colour to black
		timerMin.setBackground(Color.BLACK);
		// sets the text to'00'
		timerMin.setText("00");
		// sets columns to 10
		timerMin.setColumns(10);
		// sets the bounds to (59, 15, 27, 19)
		timerMin.setBounds(59, 15, 27, 19);
		// adds it to panelTimer
		panelTimer.add(timerMin);
		// sets the foreground colour to white
		timerSec.setForeground(Color.WHITE);
		// sets the background colour to black
		timerSec.setBackground(Color.BLACK);
		// sets the text to'00'
		timerSec.setText("00");
		// sets columns to 10
		timerSec.setColumns(10);
		// sets the bounds to (59, 15, 27, 19)
		timerSec.setBounds(108, 15, 27, 19);
		// adds it to panelTimer
		panelTimer.add(timerSec);
		// creates a JLabel label_2
		final JLabel label_2 = new JLabel(":");
		// sets the font to ("Tahoma", Font.BOLD, 14)
		label_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		// sets the bounds to (41, 15, 6, 17)
		label_2.setBounds(41, 15, 6, 17);
		// adds the label to panelTimer
		panelTimer.add(label_2);
		// creates a JLabel label_4
		final JLabel label_4 = new JLabel(":");
		// sets the font to ("Tahoma", Font.BOLD, 14)
		label_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		// sets the bounds to (41, 15, 6, 17)
		label_4.setBounds(96, 15, 6, 17);
		// adds the label to panelTimer
		panelTimer.add(label_4);
		// creates a JLabel lblScore
		final JLabel lblScore = new JLabel("SCORE");
		// sets the font to ("Tahoma", Font.BOLD, 10)
		lblScore.setFont(new Font("Tahoma", Font.BOLD, 10));
		// sets the bounds to (41, 15, 6, 17)
		lblScore.setBounds(50, 44, 45, 13);
		// adds the label to panelTimer
		panelTimer.add(lblScore);
		// sets the foreground colour to white
		scoreLeft.setForeground(Color.WHITE);
		// sets the background colour to black
		scoreLeft.setBackground(Color.BLACK);
		// sets the text to'00'
		scoreLeft.setText("00");
		// sets column to 10
		scoreLeft.setColumns(10);
		// sets the bounds to (10, 60, 27, 19)
		scoreLeft.setBounds(10, 60, 27, 19);
		// adds the textfield to panelTimer
		panelTimer.add(scoreLeft);
		// sets the foreground colour to white
		scoreRight.setForeground(Color.WHITE);
		// sets the background colour to black
		scoreRight.setBackground(Color.BLACK);
		// sets the text to'00'
		scoreRight.setText("00");
		// sets column to 10
		scoreRight.setColumns(10);
		// sets the bounds to (10, 60, 27, 19)
		scoreRight.setBounds(108, 60, 27, 19);
		// adds the textfield to panelTimer
		panelTimer.add(scoreRight);
		// creates JLabel label_5
		final JLabel label_5 = new JLabel("<L : R>");
		// sets the font to ("Tahoma", Font.BOLD, 10)
		label_5.setFont(new Font("Tahoma", Font.BOLD, 10));
		// sets the bounds to (50, 65, 45, 13)
		label_5.setBounds(50, 65, 45, 13);
		// adds the label to panelTimer
		panelTimer.add(label_5);
		// creates a JPanel panelTextBox
		final JPanel panelTextbox = new JPanel();
		// sets the bounds to (3, 97, 153, 67)
		panelTextbox.setBounds(3, 97, 153, 67);
		// adds the panel to panelRight
		panelRight.add(panelTextbox);
		// sets layout to GridBagLayout
		final GridBagLayout gbl_panelTextbox = new GridBagLayout();
		// sets columnheight and widths
		gbl_panelTextbox.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_panelTextbox.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panelTextbox.columnWeights = new double[] { 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panelTextbox.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelTextbox.setLayout(gbl_panelTextbox);
		// creates a JLabel lblOption
		final JLabel lblOption = new JLabel("OPTION:");
		// adds gridbagLayout
		final GridBagConstraints gbc_lblOption = new GridBagConstraints();
		gbc_lblOption.fill = GridBagConstraints.BOTH;
		gbc_lblOption.insets = new Insets(0, 0, 5, 5);
		// sets gridX
		gbc_lblOption.gridx = 0;
		// sets gridY
		gbc_lblOption.gridy = 0;
		// adds the panelTextBox
		panelTextbox.add(lblOption, gbc_lblOption);
		// sets column to 10
		optionBox.setColumns(10);
		// adds grdibagconstrainrts
		final GridBagConstraints gbc_optionBox = new GridBagConstraints();
		// sets width to 2
		gbc_optionBox.gridwidth = 2;
		// inserts the box
		gbc_optionBox.insets = new Insets(0, 0, 5, 0);
		gbc_optionBox.fill = GridBagConstraints.HORIZONTAL;
		// sets gridX to 2
		gbc_optionBox.gridx = 2;
		// sets gridY
		gbc_optionBox.gridy = 0;
		// adds the layout to panelTextBox
		panelTextbox.add(optionBox, gbc_optionBox);
		// creates a JLabel lblSquare
		final JLabel lblSquare = new JLabel("SQUARE:");
		// adds gridbagLayout
		final GridBagConstraints gbc_lblSquare = new GridBagConstraints();
		gbc_lblSquare.anchor = GridBagConstraints.WEST;
		gbc_lblSquare.insets = new Insets(0, 0, 5, 5);
		// sets gridXY to 0
		gbc_lblSquare.gridx = 0;
		// sets gridY to 1
		gbc_lblSquare.gridy = 1;
		// adds the layout to panelTextBox
		panelTextbox.add(lblSquare, gbc_lblSquare);
		// squareBox = new JTextField();
		squareBox.setColumns(10);
		final GridBagConstraints gbc_squareBox = new GridBagConstraints();
		gbc_squareBox.gridwidth = 2;
		gbc_squareBox.insets = new Insets(0, 0, 5, 0);
		gbc_squareBox.fill = GridBagConstraints.HORIZONTAL;
		// sets gridX to 2
		gbc_squareBox.gridx = 2;
		// sets gridY to 1
		gbc_squareBox.gridy = 1;
		// adds the layout to panelTextBox
		panelTextbox.add(squareBox, gbc_squareBox);
		final JLabel lblDirection = new JLabel("DIRECTION:");
		final GridBagConstraints gbc_lblDirection = new GridBagConstraints();
		gbc_lblDirection.anchor = GridBagConstraints.WEST;
		gbc_lblDirection.insets = new Insets(0, 0, 0, 5);
		// sets gridX to 0
		gbc_lblDirection.gridx = 0;
		// sets gridY to 2
		gbc_lblDirection.gridy = 2;
		// adds the layout to panelTextBox
		panelTextbox.add(lblDirection, gbc_lblDirection);
		directionBox.setColumns(10);
		final GridBagConstraints gbc_directionBox = new GridBagConstraints();
		gbc_directionBox.gridwidth = 2;
		gbc_directionBox.fill = GridBagConstraints.HORIZONTAL;
		// sets gridX to 2
		gbc_directionBox.gridx = 2;
		// sets gridY to 2
		gbc_directionBox.gridy = 2;
		// adds the layout to panelTextBox
		panelTextbox.add(directionBox, gbc_directionBox);
		// creates a JPanel panelDirection
		final JPanel panelDirections = new JPanel();
		// sets the bounds to (3, 166, 153, 104)
		panelDirections.setBounds(3, 166, 153, 104);
		// adds the panel to panelRight
		panelRight.add(panelDirections);
		// sets layout to null
		panelDirections.setLayout(null);
		// sets background colour to white
		btnUp.setBackground(Color.WHITE);
		// sets the bounds to (53, 11, 49, 21)
		btnUp.setBounds(53, 11, 49, 21);
		// adds the panel to panelDirections
		panelDirections.add(btnUp);
		// adds actionListener to btnUP
		btnUp.addActionListener(this);
		// sets icon of btnBall to ball.png
		btnBall.setIcon(new ImageIcon("images\\ball.png"));
		// sets the bounds to (48, 36, 61, 37)
		btnBall.setBounds(48, 36, 61, 37);
		// adds the button to panelDirections
		panelDirections.add(btnBall);
		// adds actionListener to btnBall
		btnBall.addActionListener(this);
		btnDown.setToolTipText("");
		// sets background colour to white
		btnDown.setBackground(Color.WHITE);
		// sets the bounds to (53, 78, 46, 21)
		btnDown.setBounds(53, 78, 46, 21);
		// adds the button to panelDirections
		panelDirections.add(btnDown);
		// adds actionListener to btnDown
		btnDown.addActionListener(this);
		// enables the button btnLeft
		btnLeft.setEnabled(true);
		// sets background colour to white
		btnLeft.setBackground(Color.WHITE);
		// sets the bounds to (0, 42, 47, 21)
		btnLeft.setBounds(0, 42, 47, 21);
		// adds the button to panelDirections
		panelDirections.add(btnLeft);
		// adds actionListener to btnLeft
		btnLeft.addActionListener(this);
		// sets background colour to white
		btnRight.setBackground(Color.WHITE);
		// sets the bounds to (42, 45, 47, 21)
		btnRight.setBounds(109, 42, 45, 21);
		// adds the panel to panelRight
		panelDirections.add(btnRight);
		// adds actionListener to btnRight
		btnRight.addActionListener(this);
		// sets the bounds to (3, 272, 153, 117)
		panelMap.setBounds(3, 272, 153, 117);
		// adds the panel to panelRight
		panelRight.add(panelMap);
		// sets layout to null
		panelMap.setLayout(null);
		btnMap.setDoubleBuffered(true);
		// sets background colour to white
		btnMap.setBackground(Color.WHITE);
		btnMap.setAutoscrolls(true);
		// sets the icon image to east.jpg
		btnMap.setIcon(new ImageIcon("images\\east.jpg"));
		// sets the bounds to (12, 7, 125, 96)
		btnMap.setBounds(12, 7, 125, 96);
		// adds the button to panelMap
		panelMap.add(btnMap);
		// adds actionListener to btnMap
		btnMap.addActionListener(this);
		// creates a JPanel panelRightButtons
		final JPanel panelRightButtons = new JPanel();
		// sets the bounds to (3, 390, 153, 69)
		panelRightButtons.setBounds(3, 390, 153, 69);
		// adds the panel to panelRight
		panelRight.add(panelRightButtons);
		// sets layout to null
		panelRightButtons.setLayout(null);
		// sets the font to ("Tahoma", Font.BOLD, 8)
		btnTwoPlayers.setFont(new Font("Tahoma", Font.BOLD, 8));
		// sets the bounds to (4, 12, 74, 21)
		btnTwoPlayers.setBounds(4, 12, 74, 21);
		// adds button to panelRightButtons
		panelRightButtons.add(btnTwoPlayers);
		// adds actionListener to btnTwoPlayers
		btnTwoPlayers.addActionListener(this);
		// sets the font to ("Tahoma", Font.BOLD, 8)
		btnFourPlayers.setFont(new Font("Tahoma", Font.BOLD, 8));
		// sets the bounds to (78, 12, 77, 21)
		btnFourPlayers.setBounds(78, 12, 77, 21);
		// adds button to panelRightButtons
		panelRightButtons.add(btnFourPlayers);
		// adds actionListener to btnFourPlayers
		btnFourPlayers.addActionListener(this);
		// sets the font to ("Tahoma", Font.BOLD, 10)
		btnMulti.setFont(new Font("Tahoma", Font.BOLD, 10));
		// sets the bounds to (5, 42, 73, 21)
		btnMulti.setBounds(5, 42, 73, 21);
		// adds button to panelRightButtons
		panelRightButtons.add(btnMulti);
		// adds actionListener to btnMulti
		btnMulti.addActionListener(this);
		btnExit.setDisabledIcon(null);
		// sets the font to ("Tahoma", Font.BOLD, 10)
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 10));
		// sets the bounds to (78, 42, 71, 21)
		btnExit.setBounds(78, 42, 71, 21);
		// adds button to panelRightButtons
		panelRightButtons.add(btnExit);
		// adds actionListener to btnExit
		btnExit.addActionListener(this);
		// creates a JPanel
		final JPanel panelBottom = new JPanel();
		// sets background colour to orange
		panelBottom.setBackground(Color.ORANGE);
		// sets the border to new Color(0, 0, 255), 2, true
		panelBottom.setBorder(new LineBorder(new Color(0, 0, 255), 2, true));
		// sets the bounds to (0, 475, 810, 50)
		panelBottom.setBounds(0, 475, 810, 50);
		// adds the panel to contentPane
		contentPane.add(panelBottom);
		// sets layout to null
		panelBottom.setLayout(null);
		// sets the font to ("Tahoma", Font.BOLD, 10)
		btnAct.setFont(new Font("Tahoma", Font.BOLD, 10));
		// sets background colour to white
		btnAct.setBackground(Color.WHITE);
		// sets icon to step.png
		btnAct.setIcon(new ImageIcon("images\\step.png"));
		// sets the bounds to (140, 10, 85, 21)
		btnAct.setBounds(140, 10, 85, 21);
		panelBottom.add(btnAct);
		// adds actionListener to btnAct
		btnAct.addActionListener(this);
		// sets the font to ("Tahoma", Font.BOLD, 10)
		btnRun.setFont(new Font("Tahoma", Font.BOLD, 10));
		// sets background colour to white
		btnRun.setBackground(Color.WHITE);
		// sets icon to run.png
		btnRun.setIcon(new ImageIcon("images\\run.png"));
		// sets the bounds to (140, 10, 85, 21)
		btnRun.setBounds(235, 10, 85, 21);
		// adds the button to panelBottom
		panelBottom.add(btnRun);
		// adds actionListener to btnRun
		btnRun.addActionListener(this);
		// sets the font to ("Tahoma", Font.BOLD, 10)
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 10));
		// sets background colour to white
		btnReset.setBackground(Color.WHITE);
		// sets icon to resey.png
		btnReset.setIcon(new ImageIcon("images\\reset.png"));
		// sets the bounds to (140, 10, 85, 21)
		btnReset.setBounds(330, 10, 99, 21);
		// adds the button to panelBottom
		panelBottom.add(btnReset);
		// adds actionListener to btnReset
		btnReset.addActionListener(this);
		// sets the font to ("Tahoma", Font.BOLD, 10)
		final JSlider sliderSpeed = new JSlider(1, 10);
		// sets background colour to white
		sliderSpeed.setBackground(Color.WHITE);
		// sets the bounds to (140, 10, 85, 21)
		sliderSpeed.setBounds(579, 10, 200, 22);
		// adds the button to panelBottom
		panelBottom.add(sliderSpeed);
		final JLabel lblNewLabel_2 = new JLabel("Speed:");
		// sets the font to ("Tahoma", Font.BOLD, 10)
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		// sets the bounds to (529, 14, 45, 13)
		lblNewLabel_2.setBounds(529, 14, 45, 13);
		// adds the label to panelBottom
		panelBottom.add(lblNewLabel_2);
		// sets background colour to green
		panelMain.setBackground(Color.GREEN);
		// sets the border to new LineBorder(Color.BLUE, 1, true)
		panelMain.setBorder(new LineBorder(Color.BLUE, 1, true));
		// sets the bounds to (0, 5, 649, 465)
		panelMain.setBounds(0, 5, 649, 465);
		// adds the panel to contentPane
		contentPane.add(panelMain);
		// sets layout to null
		panelMain.setLayout(null);
		// sets background colour to white
		panelGame.setBackground(Color.WHITE);
		// sets the border to new LineBorder(Color.BLUE, 2, true)
		panelGame.setBorder(new LineBorder(Color.BLACK, 2, true));
		// sets the bounds to (50, 30, 600, 400)
		panelGame.setBounds(50, 30, 600, 400);
		// adds the panel to panelMain
		panelMain.add(panelGame);
		// sets the layuot to GridLayout(13,16)
		panelGame.setLayout(new GridLayout(13, 16));
		// sets background colour to black
		panelMouse.setBackground(Color.RED);
		// sets the bounds to (0, 30, 50, 400)
		panelMouse.setBounds(0, 30, 50, 400);
		// adds the panel to panelMain
		panelMain.add(panelMouse);
		// calls the method board()
		board();
		// calls the method players()
		players();
		// calls the method ball()
		ball();

	}

	private void board() {
		// loops value of i 13 times
		for (int i = 0; i <= 12; i++) {
			// loops value of j 16 times
			for (int j = 0; j <= 15; j++) {
				// creates a dummy button
				final JButton dummy = new JButton();
				// swaps the value of dummy to grid
				grid[i][j] = dummy;
				// sets borderPainted to false
				dummy.setBorderPainted(false);
				// sets background colour to white
				grid[i][j].setBackground(Color.white);
				// checks if i is greater than 6 and smaller than 9
				if (j >= 7 && j < 9) {
					// sets the icon to wall.png
					grid[i][j].setIcon(new ImageIcon("images\\wall.png"));
				}
				// adds the grid to game panel
				panelGame.add(grid[i][j]);

			}
		}
		// sets the text to "east"
		directionBox.setText("EAST");
		// sets tje text of optionBox to "2 PLRY"
		optionBox.setText("2 PLYR");

	}

	private void ball() {
		// sets the value of bR to 6
		bR = 6;
		// sets the value of bC to 4
		bC = 4;
		// sets the image icon to ball.png
		grid[bR][bC].setIcon(new ImageIcon("images\\ball.png"));
	}

	private void players() {
		// sets the value of LR to 6
		lR = 6;
		// sets the value of lC to 1
		lC = 2;
		// sets the value of rR to 6
		rR = 6;
		// sets the value of rC to 13
		rC = 13;
		// sets the image icon to baby1.png
		grid[lR][lC].setIcon(new ImageIcon("images\\baby1.png"));
		// sets the image icon to baby2.png
		grid[rR][rC].setIcon(new ImageIcon("images\\baby2.png"));
	}

	private void playersFour() {
		// sets the value of lR to 6
		lR = 6;
		// sets the value of lc to 1
		lC = 1;
		// sets the image icon to baby1.png
		grid[lR][lC].setIcon(new ImageIcon("images\\baby1.png"));
		// sets the image icon to baby1.png
		grid[lTR][lTC].setIcon(new ImageIcon("images\\baby1.png"));
		// sets the image icon to baby2.png
		grid[rTR][rTC].setIcon(new ImageIcon("images\\baby2.png"));
		// sets the image icon to baby2.png
		grid[rBR][rBC].setIcon(new ImageIcon("images\\baby2.png"));
	}

	@Override
	public void mouseClicked(final MouseEvent e) {

	}

	@Override
	public void mousePressed(final MouseEvent e) {

	}

	@Override
	public void mouseReleased(final MouseEvent e) {

	}

	@Override
	public void mouseEntered(final MouseEvent e) {

	}

	@Override
	public void mouseExited(final MouseEvent e) {

	}

	@Override
	public void mouseDragged(final MouseEvent e) {

	}

	@Override
	public void mouseMoved(final MouseEvent e) {

	}
}
