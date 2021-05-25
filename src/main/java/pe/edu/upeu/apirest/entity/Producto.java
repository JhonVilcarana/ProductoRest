package pe.edu.upeu.apirest.entity;

public class Producto {
	private int idproducto;
	private String nombre;
	private double precio;
	private int stock;
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Producto(int idproducto, String nombre, double precio, int stock) {
		super();
		this.idproducto = idproducto;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
	}
	public int getIdproducto() {
		return idproducto;
	}
	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
}
