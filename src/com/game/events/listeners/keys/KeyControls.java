package com.game.events.listeners.keys;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.game.annotations.Empty;
import com.game.annotations.Unused;
import com.game.collision.objects.ChestTransparentObject;
import com.game.collision.objects.base.CollisionObject;
import com.game.collision.objects.base.ObjectType;
import com.game.commands.base.Commands;
import com.game.entities.player.Player;
import com.game.entities.player.items.base.Item;
import com.game.exceptions.image.restoring.NotEnoughInformationToRestoreImageException;
import com.game.logging.LogType;
import com.game.main.Game;

public class KeyControls implements KeyListener {
	
	@Unused
	@Empty
	@Override
	public void keyTyped(KeyEvent event) {
		
		
	}

	@Override
	public void keyPressed(KeyEvent event) {
		
		int key = event.getKeyCode();
		
		if (KeyEvent.VK_SHIFT == key) {
			
			Player.SPEED = Player.DASH_SPEED;
			
			Game.PLAYER.setDashKeyDown(true);
			
		}
		
		if (KeyEvent.VK_W == key || KeyEvent.VK_UP == key) {
			
			Game.PLAYER.setKeyDownAt(0, true);
			
		}
		
		if (KeyEvent.VK_S == key || KeyEvent.VK_DOWN == key) {
			
			Game.PLAYER.setKeyDownAt(1, true);
			
		}
		
		if (KeyEvent.VK_A == key || KeyEvent.VK_LEFT == key) {
			
			Game.PLAYER.setKeyDownAt(2, true);
			
		}
		
		if (KeyEvent.VK_D == key || KeyEvent.VK_RIGHT == key) {
			
			Game.PLAYER.setKeyDownAt(3, true);
			
		}
		
		if (KeyEvent.VK_SPACE == key) {
			
			Game.PLAYER.useItem();
			
		}
		
	}

	@Override
	public void keyReleased(KeyEvent event) {
		
		int key = event.getKeyCode();
		
		
		if (KeyEvent.VK_SHIFT == key) {
			
			Player.SPEED = Player.DEFAULT_SPEED;
			
			Game.PLAYER.setDashKeyDown(false);
			
		}
		
		if (KeyEvent.VK_W == key || KeyEvent.VK_UP == key) {
			
			Game.PLAYER.setKeyDownAt(0, false);
			
		}
		
		if (KeyEvent.VK_S == key || KeyEvent.VK_DOWN == key) {
			
			Game.PLAYER.setKeyDownAt(1, false);
			
		}
		
		if (KeyEvent.VK_A == key || KeyEvent.VK_LEFT == key) {
			
			Game.PLAYER.setKeyDownAt(2, false);
			
		}
		
		if (KeyEvent.VK_D == key || KeyEvent.VK_RIGHT == key) {
			
			Game.PLAYER.setKeyDownAt(3, false);
			
		}
		
		
		
		if (KeyEvent.VK_1 == key) {
			
			Game.PLAYER.getHotbar().currentItemIndex = 0;
			Game.logln("Player switched to slot 1", LogType.MESSAGE);
			
		}
		
		if (KeyEvent.VK_2 == key) {
			
			Game.PLAYER.getHotbar().currentItemIndex = 1;
			Game.logln("Player switched to slot 2", LogType.MESSAGE);
			
		}
		
		if (KeyEvent.VK_3 == key) {
			
			Game.PLAYER.getHotbar().currentItemIndex = 2;
			Game.logln("Player switched to slot 3", LogType.MESSAGE);
			
		}
		
		if (KeyEvent.VK_4 == key) {
			
			Game.PLAYER.getHotbar().currentItemIndex = 3;
			Game.logln("Player switched to slot 4", LogType.MESSAGE);
			
		}
		
		if (KeyEvent.VK_5 == key) {
			
			Game.PLAYER.getHotbar().currentItemIndex = 4;
			Game.logln("Player switched to slot 5", LogType.MESSAGE);
			
		}
		
		if (KeyEvent.VK_6 == key) {
			
			Game.PLAYER.getHotbar().currentItemIndex = 5;
			Game.logln("Player switched to slot 6", LogType.MESSAGE);
			
		}
		
		if (KeyEvent.VK_7 == key) {
			
			Game.PLAYER.getHotbar().currentItemIndex = 6;
			Game.logln("Player switched to slot 7", LogType.MESSAGE);
			
		}
		
		if (KeyEvent.VK_8 == key) {
			
			Game.PLAYER.getHotbar().currentItemIndex = 7;
			Game.logln("Player switched to slot 8", LogType.MESSAGE);
			
		}
		
		
		
		if (KeyEvent.VK_X == key) {
			
			Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex] = null;
			
		}
		
		if (KeyEvent.VK_Z == key) {
			
			if (Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex] != null) {
				
				Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex].setCount((int) (Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex].getCount() - 1));
				
				if (Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex].getCount() <= 0) {
					
					Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex] = null;
					
				}
				
			}
			
		}
		
		if (KeyEvent.VK_COMMA == key) {
			
			if (Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex] != null) {
				
				float[] pos = Game.getRandomItemPos();
				
				
				Item<?> dropItem = (Item<?>) Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex].cloneType();
				
				dropItem.setCount(1);
				
				Game.addItemEntity(pos[0], pos[1], dropItem, dropItem.getImage(), 64);
				
				Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex].setCount((int) (Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex].getCount() - 1));
				
				if (Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex].getCount() <= 0) {
					
					Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex] = null;
					
				}
			}
			
		}
		
		if (KeyEvent.VK_PERIOD == key) {
			
			if (Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex] != null) {
				
				float[] pos = Game.getRandomItemPos();
				
				Game.addItemEntity(
									pos[0],
									pos[1],
									Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex],
									Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex].getImage(),
									64
								);
				
				
				Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex] = null;
				
			}
			
		}
		
		if (KeyEvent.VK_C == key) {
			
			String res = JOptionPane.showInputDialog(null, "Enter a command to run", "Question", JOptionPane.QUESTION_MESSAGE);
			
			if (res != null && !res.isEmpty()) {
				
				Commands.run(res);
				
			}
			
		}
		
		if (KeyEvent.VK_T == key) {
			
			Game.PLAYER.trade();
			
		}
		
		if (KeyEvent.VK_Y == key) {
			
			Game.PLAYER.tradeAll();
			
		}
		
		if (KeyEvent.VK_9 == key) {
			
			Game.save();
			
		}
		
		if (KeyEvent.VK_0 == key) {
			
			Game.load();
			
		}
		
		if (KeyEvent.VK_MINUS == key) {
			
			Game.reset();
			
		}
		
		if (KeyEvent.VK_I == key) {
			
			for (int i = 0; i < Game.MAP_HANDLER().currentMap().getObjectList().size(); i++) {
				
				CollisionObject o = Game.MAP_HANDLER().currentMap().getObject(i);
				
				if (o.getType() == ObjectType.CHEST && o instanceof ChestTransparentObject && Game.PLAYER.getRectangle().intersects(o.getRectangle())) {
					
					if (Game.PLAYER.getHotbar().getCurrentItem() != null) {
						
						((ChestTransparentObject) o).push(Game.PLAYER.getHotbar().getCurrentItem());
						
						Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex] = null;
						Game.logln("Player put a item in a chest", LogType.MESSAGE);
						
					}
					
				}
				
			}
			
			try {
				
				Game.fixAllImages();
				
			} catch (NotEnoughInformationToRestoreImageException e) {
				
				System.out.println("NotEnoughInformationToRestoreImageException: " + e.toString());
				
			}
			
		}
		
		if (KeyEvent.VK_U == key) {
			
			for (int i = 0; i < Game.MAP_HANDLER().currentMap().getObjectList().size(); i++) {
				
				CollisionObject o = Game.MAP_HANDLER().currentMap().getObject(i);
				
				if (o.getType() == ObjectType.CHEST && o instanceof ChestTransparentObject && Game.PLAYER.getRectangle().intersects(o.getRectangle())) {
					
					if (Game.PLAYER.getHotbar().getCurrentItem() == null && ((ChestTransparentObject) o).isNotEmpty()) {
						
						Game.PLAYER.getHotbar().list[Game.PLAYER.getHotbar().currentItemIndex] = ((ChestTransparentObject) o).pop();
						Game.logln("Player took a item in a chest", LogType.MESSAGE);
						
					}
					
				}
				
			}
			
			try {
				
				Game.fixAllImages();
				
			} catch (NotEnoughInformationToRestoreImageException e) {
				
				System.out.println("NotEnoughInformationToRestoreImageException: " + e.toString());
				
			}
			
		}
		
		if (KeyEvent.VK_G == key) {
			
			float[] pos = Game.getRandomItemPos();
			
			Game.PLAYER.setX(pos[0]);
			Game.PLAYER.setY(pos[1]);
			
		}
		
		if (KeyEvent.VK_L == key) {
			
			try {
				
				Game.LOGGER.saveLogFile();
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
		if (KeyEvent.VK_P == key) {
			
			Game.PAUSED = !Game.PAUSED;
			
		}
		
	}

}
