package com.game.collision.objects;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.game.annotations.Empty;
import com.game.annotations.Unused;
import com.game.collision.objects.base.CollisionObject;
import com.game.collision.objects.base.ObjectType;
import com.game.entities.base.Entity;
import com.game.main.Drawable;

public class PlayerObject extends CollisionObject implements Drawable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4578070229877414941L;

	public PlayerObject(int x, int y, int width, int height, ObjectType type, BufferedImage image) {
		
		super(x, y, width, height, type, image, true);
		
		
	}
	
	@Unused
	@Empty
	@Override
	public void collide(Entity e) {
		
		
		
	}

	@Override
	public void draw(Graphics2D g2d) {
		
		g2d.drawImage(this.image, this.x, this.y, this.width, this.height, null);
		
	}

}
