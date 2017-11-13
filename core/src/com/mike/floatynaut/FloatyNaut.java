package com.mike.floatynaut;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Logger;
import com.mike.floatynaut.screen.game.GameScreen;


//heredando de Game podremos cargar screens en el juego
public class FloatyNaut extends Game {
	/*atributes*/
	private AssetManager assetManager;
	private SpriteBatch batch;

	public FloatyNaut() {
	}

	@Override
	public void create() {
		//inicializamos el bach y el assetManager que seran unicos en el juego
		assetManager = new AssetManager();
		assetManager.getLogger().setLevel(Logger.DEBUG);
		batch = new SpriteBatch();
		//cargams la pantalla inicial
		this.setScreen(new GameScreen(this));
	}

	public SpriteBatch getBatch() {
		return batch;
	}

	public AssetManager getAssetManager() {
		return assetManager;
	}

	@Override
	public void dispose() {
		super.dispose();
		/*SIEMRE DISPOSE TODOOOO LO DISPOSEABLE*/
		assetManager.dispose();
		batch.dispose();
	}


}
