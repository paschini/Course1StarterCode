package module1;

import processing.core.PApplet;
import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.providers.AbstractMapProvider;
// import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.providers.Microsoft;
import de.fhpotsdam.unfolding.utils.MapUtils;
import de.fhpotsdam.unfolding.providers.MBTilesMapProvider;


/** HelloWorld
  * An application with two maps side-by-side zoomed in on different locations.
  * Author: UC San Diego Coursera Intermediate Programming team
  * @author Camila Paschini
  * Date: October 2, 2020
  * */
public class HelloWorld extends PApplet
{
	/** Your goal: add code to display second map, zoom in, and customize the background.
	 * Feel free to copy and use this code, adding to it, modifying it, etc.  
	 * Don't forget the import lines above. */

	// You can ignore this.  It's to keep eclipse from reporting a warning
	private static final long serialVersionUID = 1L;

	/** This is where to find the local tiles, for working without an Internet connection */
	public static String mbTilesString = "blankLight-1-3.mbtiles";
	
	// IF YOU ARE WORKING OFFLINE: Change the value of this variable to true
	private static final boolean offline = false;
	
	/** The map we use to display our home town: La Jolla, CA */
	UnfoldingMap mapLaJolla;
	
	/** The map you will use to display your home town */ 
	UnfoldingMap mapStockholm;

	public void setup() {
		size(850, 600, P2D);
		this.background(33, 33, 33);

		AbstractMapProvider provider = new Microsoft.HybridProvider();

		int zoomLevel = 10;
		
		if (offline) {
			// If you are working offline, you need to use this provider 
			// to work with the maps that are local on your computer.  
			provider = new MBTilesMapProvider(mbTilesString);
			// 3 is the maximum zoom level for working offline
			zoomLevel = 3;
		}

		mapLaJolla = new UnfoldingMap(this, 50, 50, 350, 500, provider);
	    mapLaJolla.zoomAndPanTo(zoomLevel, new Location(32.9f, -117.2f));
		MapUtils.createDefaultEventDispatcher(this, mapLaJolla); // This line makes the map interactive

		mapStockholm = new UnfoldingMap(this, 450, 50, 350, 500, provider);
		mapStockholm.zoomAndPanTo(zoomLevel, new Location(59.3f, 18.0f));
		MapUtils.createDefaultEventDispatcher(this, mapStockholm);
	}

	/** Draw the Applet window.  */
	public void draw() {
		// So far we only draw map1...
		mapLaJolla.draw();
		mapStockholm.draw();
	}

	
}
