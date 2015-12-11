package es.iesnervion.android.ignacio.viewpagergaleria;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


public class AdaptadorGaleria extends PagerAdapter {
	
	private int[] imagenes = new int[] {
	        R.drawable.img1,
	        R.drawable.img2,
	        R.drawable.img3,
	        R.drawable.img4
	    };
	
	Context contexto;
	public AdaptadorGaleria(Context contexto){
    	this.contexto = contexto;
    }

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return imagenes.length;
	}

	@Override
	public boolean isViewFromObject(View vista, Object objeto) {
		// TODO Auto-generated method stub
		return vista == ((ImageView) objeto);
	}
	
	  @Override
	    public Object instantiateItem(ViewGroup container, int position) {
	      ImageView imageView = new ImageView(contexto);
	      imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
	      imageView.setImageResource(imagenes[position]);
	      ((ViewPager) container).addView(imageView, 0);
	      return imageView;
	    }

	    @Override
	    public void destroyItem(ViewGroup container, int position, Object object) {
	      ((ViewPager) container).removeView((ImageView) object);
	    }
	
	

}
