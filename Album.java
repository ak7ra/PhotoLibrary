import java.util.ArrayList;

/*
 * Homework 3
 * Ami Kano, ak7ra
 * Sources: 
 */
public class Album {

	/*
	 * name is a String type variable that contains the name of the album
	 */
	private String name;
	
	/*
	 * photos is an ArrayList of objects of type photograph
	 */
	private ArrayList<Photograph> photos;	
	
	/*
	 * the constructor makes a new album with inputs name and photos
	 */
	public Album(String name) {
		this.name = name;
		this.photos = new ArrayList<Photograph>();
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public ArrayList<Photograph> getPhotos() {
		return photos;
	}
	
	/*
	 * addPhoto adds a photograph to an album
	 * 
	 * @param p : object of type Photograph
	 * @return boolean : true if photograph was successfully added to the album, false if not
	 */
	public boolean addPhoto(Photograph p) {
		if ((p != null) && (!(photos.contains(p)))) {
			photos.add(p);
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * hasPhoto checks whether the album has a particular photo or not
	 * 
	 * @param p : object of type Photograph
	 * @return boolean : true if album has p, if not false
	 */
	public boolean hasPhoto(Photograph p) {
		if (photos.contains(p)) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * removePhoto removes a particular photo from the album
	 * 
	 * @param p : object of type Photograph 
	 * @return boolean : true if p was successfully removed from album, if not false
	 */
	public boolean removePhoto(Photograph p) {
		if (photos.contains(p)) {
			photos.remove(p);
			return true;
		} else {
			return false;
		}
	}
	
	/*
	 * numPhotographs gives the number of photographs that are in the album
	 * 
	 * @return int : number of photographs that are in the album
	 */
	public int numPhotographs() {
		return photos.size();
	}
	
	/*
	 * equals checks whether an object is the same thing as the album, based on its name
	 * 
	 * @param o : an object
	 * @return boolean : true if the object refers to the album, if not false
	 */
	public boolean equals(Object o) {
		if ((o instanceof Album) && (o != null)) {
			Album otherAlbum = (Album) o;
			if (this.name == otherAlbum.getName()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/*
	 * toString returns the name and content of the album in String form
	 * 
	 * @return String : name and content of album
	 */
	public String toString() {
		return "Album name:" + name + ", photos:" + photos;
	}
	
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
	
}
