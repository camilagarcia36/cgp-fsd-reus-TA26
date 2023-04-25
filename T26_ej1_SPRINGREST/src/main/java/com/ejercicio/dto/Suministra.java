package com.ejercicio.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="suministra")//en caso que la tabala sea diferente
public class Suministra {
	//Atributos de entidad registro_curso
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)//busca ultimo valor e incrementa desde id final de db
		private int id;
		@Column(name = "precio")//no hace falta si se llama igual
		private int precio;

		@ManyToOne
	    @JoinColumn(name = "idpieza")
	    Pieza pieza;
	 
	    @ManyToOne
	    @JoinColumn(name = "idproveedor")
	    Proveedor proveedor;

		public Suministra() {
			// TODO Auto-generated constructor stub
		}

		public Suministra(int id, int precio, Pieza pieza, Proveedor proveedor) {
			super();
			this.id = id;
			this.precio = precio;
			this.pieza = pieza;
			this.proveedor = proveedor;
		}

		/**
		 * @return the id
		 */
		public int getId() {
			return id;
		}

		/**
		 * @param id the id to set
		 */
		public void setId(int id) {
			this.id = id;
		}

		/**
		 * @return the precio
		 */
		public int getPrecio() {
			return precio;
		}

		/**
		 * @param precio the precio to set
		 */
		public void setPrecio(int precio) {
			this.precio = precio;
		}

		/**
		 * @return the pieza
		 */
		public Pieza getPieza() {
			return pieza;
		}

		/**
		 * @param pieza the pieza to set
		 */
		public void setPieza(Pieza pieza) {
			this.pieza = pieza;
		}

		/**
		 * @return the proveedor
		 */
		public Proveedor getProveedor() {
			return proveedor;
		}

		/**
		 * @param proveedor the proveedor to set
		 */
		public void setProveedor(Proveedor proveedor) {
			this.proveedor = proveedor;
		}

		@Override
		public String toString() {
			return "Suministra [id=" + id + ", precio=" + precio + ", pieza=" + pieza + ", proveedor=" + proveedor
					+ "]";
		}
	    
	    
	    
}
