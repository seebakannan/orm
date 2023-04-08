package orbean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class StudentBean {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;

	@Column(name="name")
	private String name;

	@Column(name="standard")
	private Integer standard;

	@Column(name="age")
	private Integer age;

	//	@Column(name="certificates")
	//	private Set<?> certificates;

	public StudentBean() {}


	public StudentBean(String name, Integer standard, Integer age)
	{
		this.name = name;
		this.standard = standard;
		this.age = age;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getId()
	{
		return this.id;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return this.name;
	}

	public void setStandard(Integer standard)
	{
		this.standard = standard;
	}

	public Integer getStandard()
	{
		return this.standard;
	}

	public void setAge(Integer age)
	{
		this.age = age;
	}

	public Integer getAge()
	{
		return this.age;
	}

	//	public void setCertificates(Set<?> certificates)
	//	{
	//		this.certificates = certificates;
	//	}
	//
	//	public Set<?> getCertificates()
	//	{
	//		return this.certificates;
	//	}
}
