package es.iesnervion.android.ignacio.viewpagergaleria;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuItem;

public class Galeria extends Activity {

	ViewPager viewPager;
	AdaptadorGaleria adaptador;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_galeria);

		viewPager = (ViewPager) findViewById(R.id.view_pager);
		adaptador = new AdaptadorGaleria(this);
		viewPager.setAdapter(adaptador);
		viewPager.setPageTransformer(true, new Efecto());


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.galeria, menu);
		menu.findItem(R.id.fotoAnterior).setEnabled(viewPager.getCurrentItem() > 0);
		//		menu.findItem(R.id.fotoSiguiente).setEnabled(viewPager.getCurrentItem() < adaptador.getCount() - 1);
		return true;
	}

	public boolean onPrepareOptionsMenu (Menu menu){
		super.onPrepareOptionsMenu(menu);
		menu.findItem(R.id.fotoAnterior).setEnabled(viewPager.getCurrentItem() > 0);
		menu.findItem(R.id.fotoSiguiente).setEnabled(viewPager.getCurrentItem() < adaptador.getCount() - 1);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.fotoAnterior:
			viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
			invalidateOptionsMenu(); // + android 3.
			return true;
		case R.id.fotoSiguiente:
			viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
			invalidateOptionsMenu();
			return true;
		}

		return super.onOptionsItemSelected(item);
	}






}
