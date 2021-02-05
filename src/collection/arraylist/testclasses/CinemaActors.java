package collection.arraylist.testclasses;

public class CinemaActors {

	int age;
	String name;
	String awardedMovie;
	
	public CinemaActors(int age, String name, String awardedMovie) {
		super();
		this.age = age;
		this.name = name;
		this.awardedMovie = awardedMovie;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAwardedMovie() {
		return awardedMovie;
	}
	public void setAwardedMovie(String awardedMovie) {
		this.awardedMovie = awardedMovie;
	}
	
	@Override
	public String toString() {
		return "CinemaActors [age=" + age + ", name=" + name + ", awardedMovie=" + awardedMovie + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((awardedMovie == null) ? 0 : awardedMovie.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CinemaActors other = (CinemaActors) obj;
		if (age != other.age)
			return false;
		if (awardedMovie == null) {
			if (other.awardedMovie != null)
				return false;
		} else if (!awardedMovie.equals(other.awardedMovie))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}
