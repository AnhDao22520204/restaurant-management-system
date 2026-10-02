/*==============================================================*/
/* DBMS name:      ORACLE Version 21c                           */
/* Created on:     4/25/2024 6:20:10 PM                         */
/*==============================================================*/
//create user c##jj identified by jj;
//grant connect, dba to c##jj;


--Creating Sequence 'BAN_ID_SEQ'
CREATE SEQUENCE BAN_ID_SEQ
 INCREMENT BY 1
 START WITH 112
 NOMAXVALUE
 MINVALUE 1
 NOCYCLE
 NOCACHE
/



--Creating Sequence 'NV_ID_SEQ'
CREATE SEQUENCE NV_ID_SEQ
 INCREMENT BY 1
 START WITH 401
 NOMAXVALUE
 MINVALUE 1
 NOCYCLE
 NOCACHE
/

--Creating Sequence 'MA_ID_SEQ'
CREATE SEQUENCE MA_ID_SEQ
 INCREMENT BY 1
 START WITH 452
 NOMAXVALUE
 MINVALUE 1
 NOCYCLE
 NOCACHE
/
--Creating Sequence 'HD_ID_SEQ'
CREATE SEQUENCE HD_ID_SEQ
 INCREMENT BY 1
 START WITH 637
 NOMAXVALUE
 MINVALUE 1
 NOCYCLE
 NOCACHE
/
--Creating Sequence 'CTHD_ID_SEQ'
CREATE SEQUENCE CTHD_ID_SEQ
 INCREMENT BY 1
 START WITH 852
 NOMAXVALUE
 MINVALUE 1
 NOCYCLE
 NOCACHE
/
--Creating Sequence 'ND_ID_SEQ'
CREATE SEQUENCE ND_ID_SEQ
 INCREMENT BY 1
 START WITH 1320
 NOMAXVALUE
 MINVALUE 1
 NOCYCLE
 NOCACHE
/
--Creating Sequence 'NL_ID_SEQ'
CREATE SEQUENCE NL_ID_SEQ
 INCREMENT BY 1
 START WITH 1520
 NOMAXVALUE
 MINVALUE 1
 NOCYCLE
 NOCACHE
/

--Creating Sequence 'PNK_ID_SEQ'
CREATE SEQUENCE PNK_ID_SEQ
 INCREMENT BY 1
 START WITH 1520
 NOMAXVALUE
 MINVALUE 1
 NOCYCLE
 NOCACHE
/
--Creating Sequence 'PXK_ID_SEQ'
CREATE SEQUENCE PXK_ID_SEQ
 INCREMENT BY 1
 START WITH 1400
 NOMAXVALUE
 MINVALUE 1
 NOCYCLE
 NOCACHE
/
/*==============================================================*/
/* Table: BAN                                                   */
/*==============================================================*/
create table BAN (
   MABAN                NUMBER(20)            not null ,
   TENBAN               VARCHAR2(255)             not null,
   VITRI                VARCHAR2(255),
   TRANGTHAI            VARCHAR2(255),
   constraint PK_BAN primary key (MABAN)
);
ALTER TABLE BAN MODIFY MABAN DEFAULT BAN_ID_SEQ.NEXTVAL;


ALTER TABLE BAN
MODIFY TRANGTHAI DEFAULT 'khong phuc vu';
--- tr?ng thái b?n là  dang phuc vu/ chua ph?c vu 
ALTER TABLE BAN
ADD CONSTRAINT TRANGTHAI_BAN_check CHECK (TRANGTHAI IN ('dang phuc vu', 'khong phuc vu'));

/*==============================================================*/
/* Table: CTHD                                                  */
/*==============================================================*/
create table CTHD (
   MAMONAN              NUMBER(20)            not null,
   SOHD                 NUMBER(20)            not null,
   SOLUONG              NUMBER(20)            not null,
   THANHTIEN            NUMBER(20,2)
);



/*==============================================================*/
/* Table: HOADON                                                */
/*==============================================================*/
create table HOADON (
   SOHD                 NUMBER(20)            not null,
   MANV                 NUMBER(20) ,
   MABAN                NUMBER(20),
   NGHD                 DATE,
   TONGTIEN             NUMBER(20,2),
   TRANGTHAI            VARCHAR2(255),
   constraint PK_HOADON primary key (SOHD)
);
alter table hoadon modify sohd default HD_ID_SEQ.NEXTVAL;
alter table HOADON
ADD CONSTRAINT TRANGTHAI_HOADON_check CHECK (TRANGTHAI IN ('da thanh toan', 'chua thanh toan'));

ALTER TABLE HOADON
MODIFY TRANGTHAI DEFAULT 'chua thanh toan';
ALTER TABLE HOADON
MODIFY TONGTIEN DEFAULT 0;

/*==============================================================*/



/*==============================================================*/
/* Table: KHACHHANG                                             */
/*==============================================================*/

/*==============================================================*/


/*==============================================================*/
/* Table: MONAN                                                 */
/*==============================================================*/
create table MONAN (
   MAMONAN              NUMBER(20)            not null,
   SOLUONG              NUMBER(20),
   TENMONAN             VARCHAR2(255)             not null,
   DVT                  VARCHAR2(255),
   LOAI                 VARCHAR2(255),
   GIA                  NUMBER(20,2),
   constraint PK_MONAN primary key (MAMONAN)
);
ALTER TABLE MONAN MODIFY MAMONAN DEFAULT MA_ID_SEQ.NEXTVAL;

/*==============================================================*/
/* Table: NGUOIDUNG                                             */
/*==============================================================*/
create table NGUOIDUNG (
   USERID                NUMBER(20)            not null,
   HOTEN    VARCHAR2(255),
    MATKHAU              VARCHAR2(255)             not null,
   EMAIL                VARCHAR2(255)             not null,
    SDT            varchar2(255),
   VAITRO               VARCHAR2(255)            ,
   VERIFYCODE VARCHAR2(20),
   constraint PK_NGUOIDUNG primary key (USERID)
);
ALTER TABLE NGUOIDUNG MODIFY USERID DEFAULT ND_ID_SEQ.NEXTVAL;


/*==============================================================*/
/* Table: NHANVIEN                                              */
/*==============================================================*/



create table NHANVIEN (
   MANV                 NUMBER(20)            not null,
   MAND                 NUMBER(20),
   HOTEN                VARCHAR2(255)             not null,
   NGSINH               DATE,
   NGVL                 DATE,
   SODT                 VARCHAR2(255),
   constraint PK_NHANVIEN primary key (MANV)
);
ALTER TABLE NHANVIEN MODIFY MANV DEFAULT NV_ID_SEQ.NEXTVAL;

select * from nguoidung
/*==============================================================*/
/* Table: hanghoa                                              */
/*==============================================================*/
create table NGUYENLIEU (
   MANL               NUMBER(20)            not null,
   TENNL                 VARCHAR2(255) NOT NULL,
   SOLUONG                NUMBER(20),
   TONGGT             NUMBER(20),
   NHACUNGCAP              VARCHAR2(255),
   constraint PK_NGUYENLIEU primary key (MANL)
);
ALTER TABLE NGUYENLIEU MODIFY MANL DEFAULT NL_ID_SEQ.NEXTVAL;


/*==============================================================*/
// Table: PHIEUNHAPKHO       
/*==============================================================*/
create table PHIEUNHAPKHO (
   MANK                NUMBER(20)            not null,
   MANL               NUMBER(20)not null,
   MANV              NUMBER(20),
   NGAYNHAP              DATE,
   SOLUONGNHAP            NUMBER(20),
   GIANHAP   NUMBER(20),
   constraint PK_PHIEUNHAPKHO primary key (MANK)
);
ALTER TABLE PHIEUNHAPKHO MODIFY MANK DEFAULT PNK_ID_SEQ.NEXTVAL;



/*==============================================================*/
//Table: PHIEUXUATKHO       
/*==============================================================*/
create table PHIEUXUATKHO (
   MAXK                NUMBER(20)            not null,
    MANL               NUMBER(20),
   MANV              NUMBER(20),
   NGAYXUAT              DATE,
   SOLUONGXUAT            NUMBER(20),
   GIAXUAT   NUMBER(20),
   constraint PK_PHIEUXUATKHO primary key (MAXK)
);
ALTER TABLE PHIEUXUATKHO MODIFY MAXK DEFAULT PXK_ID_SEQ.NEXTVAL;

alter table CTHD
   add constraint FK_CTHD_CTHD_MONAN foreign key (MAMONAN)
      references MONAN (MAMONAN);

alter table CTHD
   add constraint FK_CTHD_CTHD2_HOADON foreign key (SOHD)
      references HOADON (SOHD);



alter table HOADON
   add constraint FK_HOADON_CUA_BAN foreign key (MABAN)
      references BAN (MABAN);

alter table HOADON
   add constraint FK_HOADON_TAO_NHANVIEN foreign key (MANV)
      references NHANVIEN (MANV);


alter table NHANVIEN
   add constraint FK_NHANVIEN_DUOC_CAP2_NGUOIDUN foreign key (MAND)
      references NGUOIDUNG (USERID);

alter table NHANVIEN
   add constraint FK_NHANVIEN_QUAN_LY_NHANVIEN foreign key (NGQL)
      references NHANVIEN (MANV);
      
      
alter table PHIEUNHAPKHO
   add constraint FK_PHIEUNHAPKHO_TAO_NHANVIEN foreign key (MANV)
      references NHANVIEN (MANV);
            
alter table PHIEUNHAPKHO
   add constraint FK_PHIEUNHAPKHO_CO_NGUYENLIEU foreign key (MANL)
      references NGUYENLIEU (MANL);






/*INSERT INTO NHANVIEN ( HOTEN, NGSINH,MAND, NGVL, SODT) VALUES ('Nguyen Van Nhan', TO_DATE('1990-05-01'  ,'YYYY-MM-DD'), 1350, TO_DATE('2020-01-01', 'YYYY-MM-DD'), '0901234567');
INSERT INTO NHANVIEN ( HOTEN, NGSINH,MAND, NGVL, SODT) VALUES ( 'Tran Thi Thanh', TO_DATE('1991-06-01',  'YYYY-MM-DD'),1351 ,  TO_DATE('2020-02-01', 'YYYY-MM-DD'), '0901234568');

*/

      
      

