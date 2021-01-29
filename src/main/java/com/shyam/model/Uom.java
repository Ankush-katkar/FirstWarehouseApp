package com.shyam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
@Entity
@Data
@Table(name="uom_tab")
public class Uom
{
	@Id
	@Column(name="uom_id_col")
	@GeneratedValue(generator = "uom_seq")
	@SequenceGenerator(name = "uom_seq",sequenceName = "uom_seq_test")
	private Integer id;
	
	@Column(name="uom_type_col")
	private String uomType;
	
	@Column(name="uom_model_col")
	private String uomModel;
	
	@Column(name="uom_desc_col")
	private String uomDesc;

}
