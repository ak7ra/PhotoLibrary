/* 
 * Homework 3
 * Ami Kano, ak7ra
 * Sources: TA office hours, Big Java Book
 */

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;

public class PhotoLibrary {

	/*
	 * name is a String type variable that denotes the name of the person.
	 */
	private String name;  

	/*
	 * id is an int type variable that holds the unique identification number of each person.
	 */
	private int id;  

	/*
	 * photos is an arrayList type variable with elements of type Photograph that keeps the photographs that the person had posted.
	 */	
	private ArrayList<Photograph> photos;

	/*
	 * albums is a HashSet of Albums that this user has created
	 */
	private HashSet<Album> albums;

	/*
	 * The constructor creates a new object of type Person. 
	 * 
	 * @param name : name of person
	 * @param id : id of person
	 * @return void
	 */
	public PhotoLibrary(String name, int id) {
		this.name = name;
		this.id = id;
		this.photos = new ArrayList<Photograph>();
		this.albums = new HashSet<Album>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public ArrayList<Photograph> getPhotos() {
		return photos;
	}

	public HashSet<Album> getAlbums() {
		return albums;
	}

	/*
	 * takePhoto takes an object of class Photograph, checks if the person's photos include the photograph object, and adds the photograph if it was not in photos. If the photograph was added, 
	 * takePhoto returns true. If the photograph was already in photos, the function returns false. 
	 * 
	 * @param p : object of class Photograph
	 * @return boolean : true means that p is added to the person's photos, false means that p was already in person's photos
	 */
	public boolean takePhoto(Photograph p) {
		if (photos.contains(p)) {
			return false;
		} else {
			photos.add(p);
			return true;
		}
	}

	/* 
	 * hasPhoto takes an object of class Photograph and checks if the person's photos include the photograph object. If photos did have the photograph, the function returns true. If not, it 
	 * returns false.
	 * 
	 * @param p : object of class Photograph
	 * @return boolean : true means that the person's photos include p, false means that it does not
	 */
	public boolean hasPhoto(Photograph p) {
		if (photos.contains(p)) {
			return true;
		} else {
			return false;
		}
	}

	/* 
	 * numPhotographs returns the number of photographs that the person's photos contains. 
	 * 
	 * @return photos.size() : how many photographs are in the person's photos
	 */
	public int numPhotographs() {
		return photos.size();
	}

	/*
	 * equals takes an object and checks if the object is the same as the person. It does this by checking whether the id of the person matches that of the object. If the object and the person
	 * are the same, the function returns true. If not, it returns false.
	 * 
	 * @param o : an object 
	 * @return boolean : true if o and the person are the same, false if not
	 */
	public boolean equals(Object o) {
		if ((o instanceof PhotoLibrary) && (o != null)) {
			PhotoLibrary otherPerson = (PhotoLibrary) o;
			if (this.id == otherPerson.getId()) {
				return true;
			} 
		}
		return false;
	}

	/*
	 * toString returns the name, id, photos and albums of the person in string form.
	 * 
	 * @return : string of name, id, photos, and albums
	 */
	public String toString() {
		return "[Name:" + name + ", ID:" + id + ", Photos:" + photos + ", Albums:" + albums;
	}

	/*
	 * commonPhotos takes two objects of class Person and returns the arrayList of objects of class Photograph that are both present in photos of the two class Persons. 
	 * 
	 * @param a : object of class Person
	 * @param b : object of class Person
	 * @return ans : arraylist of photographs that are in photos of both a and b
	 */
	public static ArrayList<Photograph> commonPhotos(PhotoLibrary a, PhotoLibrary b) {
		ArrayList<Photograph> ans = new ArrayList<Photograph>();
		for (Photograph photo : a.getPhotos()) {
			if (b.getPhotos().contains(photo)) {
				ans.add(photo);
			}
		}
		return ans;
	}

	/*
	 * similarity takes two objects of class Person and returns a number between 0 and 1 which indicates a measure of how similar the photo feeds are between the two class Persons. 
	 * 
	 * @param a : object of class Person
	 * @param b : object of class Person
	 * 
	 * @return float : indicator of how similar the photos of a and b are
	 */
	public static double similarity(PhotoLibrary a, PhotoLibrary b) {
		if ((a.getPhotos().size() == 0) || (b.getPhotos().size() == 0)) {
			return 0.0;
		} else {
			return commonPhotos(a, b).size() / ((float) Math.min(a.getPhotos().size(), b.getPhotos().size()));
		}
	}

	/*
	 * getPhotos takes a number and returns the photos that have the same or higher ratings.
	 * 
	 * @param rating : int from 0 to 5
	 * @return ans : ArrayList of photos that have ratings equal to or more than the parameter
	 */
	public ArrayList<Photograph> getPhotos(int rating) {
		if ((0 > rating) || (rating > 5)) {
			return null;
		}
		ArrayList<Photograph> ans = new ArrayList<Photograph>();
		for (Photograph photo : this.photos) {
			if (photo.getRating() >= rating) {
				ans.add(photo);
			}
		}
		return ans;
	}

	/*
	 * getPhotosInYear collects a list of photos that were taken on a particular year.
	 * 
	 * @param year : number that denotes the year in which a photo was taken
	 * @return ans : ArrayList of photos that were taken in the year given by the parameter
	 */
	public ArrayList<Photograph> getPhotosInYear(int year) {
		if ((Integer.toString(year).length() != 4)) {
			return null;
		}
		ArrayList<Photograph> ans = new ArrayList<Photograph>();
		for (Photograph photo : this.photos) {

			if (photo.getDateTaken() == null) {

			}
			else if (photo.getDateTaken().substring(0, 4).equals(Integer.toString(year))) {
				//System.out.println(photo.getDateTaken().substring(0, 4));
				ans.add(photo);
			}
			else
			{

			}
		}
		return ans;
	}

	/*
	 * getPhotosInMonth collects a list of photos that were taken on a particular month in a particualr year
	 * 
	 * @param month : month in which the photo was taken
	 * @param year : year in which the photo was taken
	 * @return ans : ArrayList of photos that were taken on the year and month given by the parameter
	 */
	public ArrayList<Photograph> getPhotosInMonth(int month, int year) {
		if ((month <= 0) || (month >= 13) || (Integer.toString(year).length() != 4)) {
			return null;
		}
		ArrayList<Photograph> ans = new ArrayList<Photograph>();
		for (Photograph photo : this.photos) {
			if (!(photo.getDateTaken() == null)) {
				if ((Integer.valueOf(photo.getDateTaken().substring(0, 4)) == year) && (Integer.valueOf(photo.getDateTaken().substring(5, 7)) == month)) {
					ans.add(photo);
				}
			}
		}
		return ans;
	}

	/*
	 * getPhotosBetween collects photos that were taken between two certain dates
	 * 
	 * @param beginDate : beginning of the time frame in which the photo is taken
	 * @param endDate : end of the time frame in which the photo is taken
	 * @result ans : ArrayList of photos that were taken between beginDate and endDate
	 */
	public ArrayList<Photograph> getPhotosBetween(String beginDate, String endDate) {
		if ((Integer.valueOf(beginDate.substring(5, 7)) <= 0) 
				|| ((Integer.valueOf(beginDate.substring(5, 7)) >= 13))
				|| ((Integer.valueOf(beginDate.substring(8)) <= 0))
				|| ((Integer.valueOf(beginDate.substring(8)) >= 32))
				|| (Integer.valueOf(endDate.substring(5, 7)) <= 0) 
				|| ((Integer.valueOf(endDate.substring(5, 7)) >= 13))
				|| ((Integer.valueOf(endDate.substring(8)) <= 0))
				|| ((Integer.valueOf(endDate.substring(8)) >= 32))) {
			return null;
		}
		ArrayList<Photograph> ans = new ArrayList<Photograph>();
		for (Photograph photo : this.photos) { //put in Photographs that were taken later than beginDate
			if (!(photo.getDateTaken() == null)) {
				if ((Integer.valueOf(photo.getDateTaken().substring(0, 4))) > Integer.valueOf(beginDate.substring(0, 4))) {
					ans.add(photo);
				} else if (photo.getDateTaken().substring(0, 4).equals(beginDate.substring(0, 4))) {
					if ((Integer.valueOf(photo.getDateTaken().substring(5, 7))) > Integer.valueOf(beginDate.substring(5, 7))) {
						ans.add(photo);
					} else if (photo.getDateTaken().substring(5, 7).equals(beginDate.substring(5, 7))) {
						if ((Integer.valueOf(photo.getDateTaken().substring(8))) >= Integer.valueOf(beginDate.substring(8))) {
							ans.add(photo);
						}
					}
				}
			}
		}
		if (ans.size() > 0) {
			for (Photograph photoz : ans) { //remove Photographs that were taken later than endDate
				if (!(photoz.getDateTaken() == null)) {
					if ((Integer.valueOf(photoz.getDateTaken().substring(0, 4))) > Integer.valueOf(endDate.substring(0, 4))) {
						ans.remove(photoz);
					} else if (photoz.getDateTaken().substring(0, 4).equals(endDate.substring(0, 4))) {
						if ((Integer.valueOf(photoz.getDateTaken().substring(5, 7))) > Integer.valueOf(endDate.substring(5, 7))) {
							ans.remove(photoz);
						} else if (photoz.getDateTaken().substring(5, 7).equals(beginDate.substring(5, 7))) {
							if ((Integer.valueOf(photoz.getDateTaken().substring(8))) >= Integer.valueOf(beginDate.substring(8))) {
								ans.remove(photoz);
							}
						}
					}
				}	
			} 
		}
		return ans;
	}


	/*
	 * createAlbum creates a new album and puts it into albums
	 * 
	 * @param albumname : name of album in String form
	 * @return boolean : true if the new album was successfully added, if not false
	 */
	public boolean createAlbum(String albumname) {
		for (Album album : this.albums) {
			if (album.getName().equals(albumname)) {
				return false;
			}
		}
		albums.add(new Album(albumname));
		return true;
	}
	

	/*
	 * removeAlbum removes an album from albums
	 * 
	 * @param albumname : name of album in String form
	 * @return boolean : true if the album was successfully removed, if not false
	 */
	public boolean removeAlbum(String albumname) {
		for (Album album : albums) {
			if (album.getName().equals(albumname)) {
				albums.remove(new Album(albumname));
				return true;
			}
		}
		return false;
	}

	/*
	 * addPhotoToAlbum adds a photo into an album
	 * 
	 * @param p : Photograph that will be added to the album
	 * @param albumName : String form of the name of album in which p will be added
	 * @return boolean : true if p was successfully added to the album, if not false
	 */
	public boolean addPhotoToAlbum(Photograph p, String albumName) {
		if (photos.contains(p)) {
			for (Album album : albums) {
				if (album.getName() == albumName) {
					album.addPhoto(p);
					return true;
				}
			}
		}
		return false;
	}


	/*
	 * removePhotoFromAlbum removes a photo from an album
	 * 
	 * @param p : Photograph that will be removed from the album
	 * @param albumName : String form of the name of album from which p will be removed
	 * @remove boolean : true if p was successfully removed from album, if not false
	 */
	public boolean removePhotoFromAlbum(Photograph p, String albumName) {
		for (Album album : albums) {
			if (album.getName() == albumName) {
				album.removePhoto(p);
				return true;
			}
		}
		return false;
	}

	/*
	 * getAlbumByName returns the album that has the same name as the input
	 * 
	 * @param albumName : String form of name of album
	 * @return album : album that has the same name as albumName
	 */
	private Album getAlbumByName(String albumName) {
		for (Album album : albums) {
			if (album.getName() == albumName) {
				return album;
			}
		}	
		return null;
	}

	/* erasePhoto takes an object of class Photograph and removes it from the person's photos. If the photograph was successfully removed, the function returns true. If the photograph was not 
	 * in photos, the function returns false. 
	 * 
	 * @param p : object of class Photograph
	 * @return boolean : true means that it successfully removed p from the person's photos, false means that p was not in photos from the start
	 */
	public boolean erasePhoto(Photograph p) {
		if (photos.contains(p)) {
			photos.remove(p);
			for (Album album : albums) {
				if (album.getPhotos().contains(p)) {
					album.getPhotos().remove(p);
				}
			}
			return true;
		} else {
			return false;
		}
	}

	public static void main(String [] args) {
		PhotoLibrary Bob = new PhotoLibrary("Bob", 7890); //testing constructor
		System.out.println(Bob.getName());
		System.out.println(Bob.getId());

		Photograph p = new Photograph("pcaption", "pfilename"); //testing takePhoto, numPhotographs and hasPhoto
		Bob.takePhoto(p);
		System.out.println(Bob.numPhotographs());
		System.out.println(Bob.hasPhoto(p));

		Bob.erasePhoto(p); //testing erasePhoto
		System.out.println(Bob.getPhotos());

		PhotoLibrary Tom = new PhotoLibrary("Tom", 7890); //testing equals and constructor
		System.out.println(Bob.equals(Tom));

		System.out.println(Tom.toString()); //testing toString

		PhotoLibrary Sam = new PhotoLibrary("Sam", 1234); //testing commonPhotos and takePhoto
		Photograph q = new Photograph("qcaption", "qfilename");
		Photograph r = new Photograph("rcaption", "rfilename");
		Photograph s = new Photograph("scaption", "sfilename");
		Sam.takePhoto(r);
		Sam.takePhoto(p);
		Sam.takePhoto(q);
		//		Tom.takePhoto(p);
		//		Tom.takePhoto(r);
		//		Tom.takePhoto(s);
		System.out.println(commonPhotos(Tom, Sam));

		System.out.println(similarity(Tom, Sam)); //testing similarity

		System.out.println(Sam.hasPhoto(s)); //testing hasPhoto with output as false

		Sam.erasePhoto(s); //testing erasePhoto with output as false, numPhotographs, and toString
		System.out.println(Sam.numPhotographs());
		System.out.println(Sam.toString());

		System.out.println(Sam.equals(Tom)); //testing equals with output as false

		PhotoLibrary Tim = new PhotoLibrary("Tim", 2345); //testing erasePhotos and similarity
		Tim.takePhoto(s);
		Tim.takePhoto(p);
		Tom.erasePhoto(s);
		Tom.erasePhoto(p);
		System.out.println(commonPhotos(Tim, Tom));
		System.out.println(similarity(Tim, Tom));

		System.out.println("TEST YEAR");

		Photograph j = new Photograph("jcaption", "jFilename", "2000-12-31", 4);
		//		Tom.takePhoto(j);
		System.out.println(Tom.getPhotos());
		System.out.println(Tom.getPhotosInYear(2000)); 

		System.out.println("BETWEEN");

		Photograph u = new Photograph("ufilename", "ucaption", "2013-02-15", 5);
		Tom.takePhoto(u);
		System.out.println(Tom.getPhotosBetween("1999-12-31", "2010-06-08"));

		System.out.println("RATINGGET");

		Photograph t = new Photograph("tfilename", "tcaption", "2012-03-22", 2);

		Photograph v = new Photograph("vfilename", "vcaption", "2000-01-01", 4);
		Bob.takePhoto(t);
		Bob.takePhoto(u);
		Bob.takePhoto(v);
		System.out.println(Bob.getPhotos(3));


	}

}


