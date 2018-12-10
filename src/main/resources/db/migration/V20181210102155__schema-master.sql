create table produk
(
  id       character varying(64)  not null primary key,
  nama     character varying(150) not null,
  harga numeric(8,2) not null,
  penjual_id    character varying(64) not null
);

create table penjual
(
id  character varying(64) not null primary key,
nama    character varying(150) not null,
deposit numeric(12,2) not null
);

alter table produk add constraint fk_penjual_produk foreign key (penjual_id)
references penjual(id) on update cascade on delete restrict;

create table pembeli
(
  id       character varying(64)  not null primary key,
nama     character varying(150) not null,
no_ktp character varying(150) not null,
alamat character varying(150) not null,
saldo numeric(12,2) not null
);

create table transaksi
(
  id       character varying(64)  not null primary key,
tanggal_transaksi     date not null default now(),
pembeli_id character varying(64) not null,
produk_id character varying(64) not null,
qty integer not null,
biaya numeric(8,2) not null
);

alter table transaksi add constraint fk_transaksi_produk foreign key (produk_id)
references produk(id) on update cascade on delete restrict;

alter table transaksi add constraint fk_pembeli_id foreign key (pembeli_id)
references pembeli(id) on update cascade on delete restrict;

