
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.*;


public class PhotoLibraryTest {

	PhotoLibrary Tom = new PhotoLibrary("Tom", 7890);
	PhotoLibrary Bob = new PhotoLibrary("Bob", 7890);
	PhotoLibrary Sam = new PhotoLibrary("Sam", 1234);
	
	Photograph q = new Photograph("qcaption", "qfilename");
	Photograph r = new Photograph("rcaption", "rfilename");
	Photograph s = new Photograph("scaption", "sfilename");
	Photograph t = new Photograph("tfilename", "tcaption", "2012-03-22", 2);
	Photograph u = new Photograph("ufilename", "ucaption", "2013-02-15", 5);
	Photograph v = new Photograph("vfilename", "vcaption", "2000-01-01", 4);
	
	
	//Similarity() test #1
	@Test
    public void testSimilarity() {
		Sam.takePhoto(r);
		Sam.takePhoto(t);
		Tom.takePhoto(t);
		Tom.takePhoto(r);
		Tom.takePhoto(s);
		assertTrue(PhotoLibrary.similarity(Tom, Sam) == 1);
	}

	//Similarity() test #2
	@Test
	public void testSimilarity2() {
		Sam.takePhoto(u);
		Sam.takePhoto(q);
		Tom.takePhoto(t);
		Tom.takePhoto(r);
		Tom.takePhoto(s);
		assertTrue(PhotoLibrary.similarity(Tom, Sam) == 0);
	}
	
	//getPhotos() test #1
	@Test
	public void testGetPhotos() {
		Bob.takePhoto(t);
		Bob.takePhoto(u);
		Bob.takePhoto(v);
		assertTrue(Bob.getPhotos(3).toString().equals("[[Caption:ucaption, Filename:ufilename], [Caption:vcaption, Filename:vfilename]]"));
	}
	
	//getPhotos() test #2
	@Test
	public void testGetPhotos2() {
		Tom.takePhoto(t);
		Tom.takePhoto(v);
		assertTrue(Tom.getPhotos(5).toString().equals("[]"));
	}
	
	//getPhotosInMonth() test #1
	@Test
	public void testGetPhotosInMonth() {
		Tom.takePhoto(t);
		assertTrue(Tom.getPhotosInMonth(03, 2012).toString().equals("[[Caption:tcaption, Filename:tfilename]]"));
	}
		
	//getPhotosInMonth() test #2
	@Test
	public void testGetPhotosInMonth2() {
		Tom.takePhoto(t);
		Tom.takePhoto(u);
		Tom.takePhoto(v);
		assertTrue(Tom.getPhotosInMonth(02, 2012).toString().equals("[]"));
	}
	
	//getPhotosBetween() test #1
	@Test
	public void testGetPhotosBetween() {
		Tom.takePhoto(u);
		assertTrue(Tom.getPhotosBetween("2011-01-01", "2013-12-31").toString().equals("[[Caption:ucaption, Filename:ufilename]]"));
	}
	
	//getPhotosBetween() test #2
	@Test
	public void testGetPhotosBetween2() {
		Tom.takePhoto(u);
		assertTrue(Tom.getPhotosBetween("1999-12-31", "2010-06-08").toString().equals("[]"));
	}
	
	//erasePhoto() test #1
	@Test
	public void testErasePhoto() {
		Tom.takePhoto(u);
		assertTrue(Tom.erasePhoto(u));
	}

	//erasePhoto() test #2
	@Test
	public void testErasePhoto2() {
		assertTrue(false == Tom.erasePhoto(u));
	}
}
