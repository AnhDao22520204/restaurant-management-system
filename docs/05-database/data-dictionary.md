# Data Dictionary

| Entity | Fields documented in the report | Business meaning |
|---|---|---|
| NGUOIDUNG | ID_USER, MATKHAU, EMAIL, VAITRO | User login identity, password, email, role |
| NHANVIEN | MANV, HOTEN, NGSINH, NGVL, SODT, CHUCVU, ID_USER | Employee profile and role/job information |
| MONAN | MAMONAN, TEN_MA, LOAI_MA, DVT, GIA, TRANGTHAI | Food/menu item information and operating status |
| BAN | MABAN, TENBAN, VITRI, TRANG_THAI | Restaurant table identity, position, service status |
| VOUCHER | MA_VOUCHER, TEN_VOUCHER, PHANTRAM, NGAY_BD, NGAY_KT | Voucher identity, discount percentage, effective dates |
| HOADON | SOHD, NGHD, TIENMONAN, TIENGIAM, TONGTIEN, TRANGTHAI, PTTT, MANV, MABAN, MA_VOUCHER | Invoice totals, discount, payment status/method and related employee/table/voucher |
| CTHD | MA_CTHD, SOHD, MAMONAN, SOLUONG, GHICHU | Invoice/order detail lines, food quantity, customer note |
| NGUYENLIEU | MA_NL, TEN_NL, SOLUONG, GIA, NHACUNGCAP, HSD | Ingredient/item inventory, supplier and expiry information |
| PHIEUNHAPKHO | MA_NK, NGAYNHAP, MANV, MA_NL, SLNHAP, GIANHAP | Inbound stock document information |
| PHIEUXUATKHO | MA_XK, NGAYXUAT, MANV, MA_NL, SLXUAT, GIAXUAT | Outbound stock document information |


