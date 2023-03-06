/* 
 * Homework 3
 * Ami Kano, ak7ra
 * Sources: TA office hours, Big Java Book
 */

public class Photograph {
	
	/*
	 * caption is a String type variable that denotes the caption of each photograph
	 */
	private String caption; 
	
	/*
	 * filename is a String type variable that denotes the filename of each photograph
	 */
	private String filename; 
	
	/*
	 * dateTaken is a String type variable that denotes the date that the photograph was taken in format of YYYY-MM-DD
	 */
	private String dateTaken;
	
	/*
	 * rating is an int type variable that rates the photograph from 0-5
	 */
	private int rating;
	
	/*
	 * the constructor creates a new object of class Photograph using the inputs caption and filename. 
	 * 
	 * @param caption : caption of the photograph that is to be created
	 * @param filename : filename of the photograph that is to be created
	 */
	public Photograph(String caption, String filename) {
		this.caption = caption;
		this.filename = filename;
	}
	
	/*
	 * this constructor creates a new object of class Photograph using the inputs caption, filename, dateTaken, and rating 
	 */
	public Photograph(String filename, String caption, String dateTaken, int rating) {
		this.filename = filename;
		this.caption = caption;
		this.dateTaken = dateTaken;
		this.rating = rating;
	}

	public String getCaption() {
		return caption;
	}

	public String getFilename() {
		return filename;
	}
	
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getDateTaken() {
		return dateTaken;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}
	
	/*
	 * equals takes an object and checks whether the object is the same as the photograph. It does this by checking whether the caption and filename of the object match that of the photograph.
	 * if the object and the photograph are the same, the function returns true. If not, it returns false.
	 * 
	 * @param o : an object
	 * @return boolean : true if o and the photograph is the same, false if not
	 */
	public boolean equals(Object o) {
		if ((o instanceof Photograph) && (o != null)) {
			Photograph otherPhoto = (Photograph) o;
			if (this.caption == otherPhoto.getCaption() && this.filename == otherPhoto.getFilename()) {
				return true;
			} 
		}
		return false;
	}

	/*
	 * toString returns the caption and filename of the photograph in String form. 
	 * 
	 * @return String : caption and filename of photograph in String form
	 */
	public String toString() {
		return "[Caption:" + caption + ", Filename:" + filename + "]";
	}
	
    @Override
    public int hashCode() {
        return (this.caption + "---" + this.filename).hashCode();
    }
	
	public static void main(String[] args) {
		
		Photograph p = new Photograph("pcaption", "pfilename", "2111-12-21", 5); //testing constructor and equals with output as false
		Photograph q = new Photograph("qcaption", "qfilename", "2312-09-22", 0);
		System.out.println(p.equals(q));
		
		Photograph r = new Photograph("pcaption", "pfilename"); //testing equals with output as true
		System.out.println(p.equals(r));
		
		System.out.println("GETRATING");
		
		PhotoLibrary JJ = new PhotoLibrary("JJ", 2333);
		JJ.takePhoto(p);
		JJ.takePhoto(q);
		System.out.println(JJ.getPhotos(5));
		
	}

}
