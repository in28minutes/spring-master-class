## First 5 Steps in Eclipse

- Git Repository - https://github.com/in28minutes/getting-started-in-5-steps
- Pre-requisites - Java & Eclipse - https://www.youtube.com/playlist?list=PLBBog2r6uMCSmMVTW_QmDLyASBvovyAO3

> If you are using mac, use Cmd instead of Ctrl. 
> In Windows, use Windows -> Preferences for Preferences.

- Step 1 : Create a Java Project 
  - Create and run a Java class
- Step 2 : Keyboard Shortcuts
  - Ctrl + Space
    - BigDecimal - Auto Suggestion
    - Templates - main, fore, sysout, syserr
  - Ctrl + 1
    - File Name and Class Name does not match - Display Errors
    - Rename a Class - What suggestions are offered?
    - new Integer() - What suggestions are offered?
  - Ctrl + Shift + R (and T)
  - F3 (Goto declaration)
  - F4 (Type Hierarchy)
  - Ctrl + Shift + L
- Step 3 : Views and Perspectives
- Step 4 : Save Actions
- Step 5 : Code Generation
    - Alt + Shift + S
      - Getters and Setters
      - toString()
      - equals()
      - hashcode()

## Complete Code Example


### /src/HelloWorld.java

```java
import java.util.HashMap;
import java.util.Map;

public class HelloWorld {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("key", "value");
	}
}
```
---

### /src/Person.java

```java
public class Person {
	private String firstName;
	private String lastName;
	private String ssn;

	public Person(String firstName, String lastName, String ssn) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	@Override
	public String toString() {
		return String.format("Person [firstName=%s, lastName=%s, ssn=%s]", firstName, lastName, ssn);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
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
		Person other = (Person) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (ssn == null) {
			if (other.ssn != null)
				return false;
		} else if (!ssn.equals(other.ssn))
			return false;
		return true;
	}

}
// Alt + Shift + S
// Cmd + Option + S
```
---
