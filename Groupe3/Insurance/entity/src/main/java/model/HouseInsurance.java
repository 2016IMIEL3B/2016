/**
 * 
 */
package model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Enzo
 *
 */
@Entity
@Table(name="houseinsurance")
public class HouseInsurance {
	@Id
	@Column(name="idHouseInsurance")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	@Column(name="option")
	int option;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "idInsurance")
	private Insurance insurance;

	protected HouseInsurance() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOption() {
		return option;
	}

	public void setOption(int option) {
		this.option = option;
	}
}
