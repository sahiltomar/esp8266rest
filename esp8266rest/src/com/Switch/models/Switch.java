package com.Switch.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Switch
 *
 */
@Entity
public class Switch implements Serializable {

	@Transient
	private static final long serialVersionUID = 1L;

	public Switch() {
		super();
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer Id;

	private String switchName;

	//@Enumerated(EnumType.STRING)
	private String switchState;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getSwitchName() {
		return switchName;
	}

	public void setSwitchName(String switchName) {
		this.switchName = switchName;
	}

	
	public String getSwitchState() {
		return switchState;
	}

	public void setSwitchState(String switchState) {
		this.switchState = switchState;
	}

	public Switch(String switchName, String switchState) {
		super();
		this.switchName = switchName;
		this.switchState = switchState;
	}

}
