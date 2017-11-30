use unlamdb;

delete from combo_ingrediente;
delete from combo;

select * from categoria;
select * from combo;
select * from combo_ingrediente;
select * from combo_pedido;
select *from pedido;
select * from ingrediente ;

select *from usuario;

insert into estadopedido(descripcion)
    values  ("En proceso de preparacion"),
            ("En proceso de entrega"),
            ("Entregado");
            
insert into categoria(descripcion)
    values  ("Pan"),
            ("Carne"),
            ("Aderezo"),
            ("Vegetales");

insert into rol(nombre)
    values  ("Administrador"),
            ("Cliente"),
            ("Cajero"),
            ("Cocinero");
            
insert into usuario(nombre,email,password,idRol)
values  ('JuanMa','admin@gmail.com','1234',1),     
        ('Pablo','cliente@gmail.com','1234',2),
        ('Cajero','cajero@gmail.com','1234',3),
        ('Cocinero','cocinero@gmail.com','1234',4);

select * from estadopedido;
select * from usuario;

insert into ingrediente(nombre, precio, tiempoCoccion, stock, idCategoria,activo)
    values  ("Pan Blanco",20.00,null,30,1,1),
            ("Pan Negro",20.00,null,30,1,1),
            ("Pan De Campo",20.00,null,30,1,1),
            ("Res",50.00,15,30,2,1),
            ("Pollo",50.00,20,30,2,1),
            ("Mayonesa",5.00,null,30,3,1),
            ("Ketchup",5.00,null,30,3,1),
            ("Mostaza",5.00,null,30,3,1),
            ("Tomate",8.00,null,30,4,1),
            ("Cebolla",8.00,null,30,4,1),
            ("Pepino",8.00,null,30,4,1),
            ("Lechuga",8.00,null,30,4,1);
 
insert into estadopedido(descripcion)
    values  ("En proceso de preparacion"),
    		("En proceso de entrega"),
    		("Entregado");