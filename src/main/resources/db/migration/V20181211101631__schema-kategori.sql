create table kategori
(
  id   character varying(64)  not null primary key,
  nama character varying(100) not null
);

create TABLE kategori_produk(
  produk_id character varying(64) not null,
  kategori_id character VARYING(64) NOT NULL
);



alter TABLE kategori_produk
add constraint fk_kategori_produk_id FOREIGN KEY (produk_id)
REFERENCES produk(id) on UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE kategori_produk
add constraint fk_kategori_produk_kategori_id foreign key (kategori_id)
references kategori(id) on update cascade on delete cascade;

alter table kategori_produk
add constraint uq_kategori_produk unique (produk_id,kategori_id);