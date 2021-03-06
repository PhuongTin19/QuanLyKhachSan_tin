USE [master]
GO
/****** Object:  Database [GFTHotel]    Script Date: 18/3/2022 1:38:53 PM ******/
CREATE DATABASE [GFTHotel]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'GFTHotel', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\DATA\GFTHotel.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'GFTHotel_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\DATA\GFTHotel_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [GFTHotel] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [GFTHotel].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [GFTHotel] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [GFTHotel] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [GFTHotel] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [GFTHotel] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [GFTHotel] SET ARITHABORT OFF 
GO
ALTER DATABASE [GFTHotel] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [GFTHotel] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [GFTHotel] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [GFTHotel] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [GFTHotel] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [GFTHotel] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [GFTHotel] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [GFTHotel] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [GFTHotel] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [GFTHotel] SET  DISABLE_BROKER 
GO
ALTER DATABASE [GFTHotel] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [GFTHotel] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [GFTHotel] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [GFTHotel] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [GFTHotel] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [GFTHotel] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [GFTHotel] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [GFTHotel] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [GFTHotel] SET  MULTI_USER 
GO
ALTER DATABASE [GFTHotel] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [GFTHotel] SET DB_CHAINING OFF 
GO
ALTER DATABASE [GFTHotel] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [GFTHotel] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [GFTHotel] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [GFTHotel] SET QUERY_STORE = OFF
GO
USE [GFTHotel]
GO
/****** Object:  Table [dbo].[DatPhong]    Script Date: 18/3/2022 1:38:53 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DatPhong](
	[MaDP] [nchar](10) NOT NULL,
	[NgayDat] [date] NOT NULL,
	[NgayTra] [date] NOT NULL,
	[MaNV] [nchar](10) NOT NULL,
	[MaPhong] [nchar](10) NOT NULL,
	[MaKH] [nchar](10) NOT NULL,
	[TienCoc] [float] NOT NULL,
 CONSTRAINT [PK_DatPhong] PRIMARY KEY CLUSTERED 
(
	[MaDP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DichVu]    Script Date: 18/3/2022 1:38:53 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DichVu](
	[MaDV] [nchar](10) NOT NULL,
	[TenDV] [nvarchar](50) NOT NULL,
	[Gia] [float] NOT NULL,
 CONSTRAINT [PK_DichVu] PRIMARY KEY CLUSTERED 
(
	[MaDV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DKDichVu]    Script Date: 18/3/2022 1:38:53 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DKDichVu](
	[MaDK] [nchar](10) NOT NULL,
	[MaDV] [nchar](10) NOT NULL,
	[MaKH] [nchar](10) NOT NULL,
	[Gia] [float] NOT NULL,
	[SLDichVu] [int] NULL,
 CONSTRAINT [PK_DKDichVu] PRIMARY KEY CLUSTERED 
(
	[MaDK] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 18/3/2022 1:38:53 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MaKH] [nchar](10) NOT NULL,
	[HoTen] [nvarchar](50) NOT NULL,
	[NgaySinh] [date] NOT NULL,
	[GioiTinh] [bit] NOT NULL,
	[CCCD] [varchar](12) NOT NULL,
	[DiaChi] [nvarchar](100) NOT NULL,
	[Email] [varchar](50) NOT NULL,
	[SDT] [varchar](12) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 18/3/2022 1:38:53 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[MaNV] [nchar](10) NOT NULL,
	[HoTen] [nvarchar](50) NOT NULL,
	[NgaySinh] [date] NOT NULL,
	[GioiTinh] [bit] NOT NULL,
	[CCCD] [varchar](12) NOT NULL,
	[DiaChi] [nvarchar](100) NOT NULL,
	[Email] [varchar](50) NOT NULL,
	[SDT] [varchar](12) NOT NULL,
	[ChucVu] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Phong]    Script Date: 18/3/2022 1:38:53 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Phong](
	[MaPhong] [nchar](10) NOT NULL,
	[TenPhong] [nvarchar](20) NOT NULL,
	[LoaiPhong] [nvarchar](20) NOT NULL,
	[TinhTrang] [nvarchar](20) NOT NULL,
	[GiaPhong] [float] NOT NULL,
	[MaNV] [nchar](10) NOT NULL,
 CONSTRAINT [PK_Phong] PRIMARY KEY CLUSTERED 
(
	[MaPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 18/3/2022 1:38:53 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[TenTK] [varchar](50) NOT NULL,
	[MatKhau] [varchar](50) NOT NULL,
	[ChucVu] [nvarchar](10) NOT NULL,
	[MaNV] [nchar](10) NOT NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[TenTK] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ThanhToan]    Script Date: 18/3/2022 1:38:53 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThanhToan](
	[MaTT] [int] IDENTITY(1,1) NOT NULL,
	[MaDK] [nchar](10) NOT NULL,
	[MaDP] [nchar](10) NOT NULL,
	[MaNV] [nchar](10) NOT NULL,
	[MaKH] [nchar](10) NOT NULL,
	[ThanhTien] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaTT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[DatPhong] ([MaDP], [NgayDat], [NgayTra], [MaNV], [MaPhong], [MaKH], [TienCoc]) VALUES (N'DP01      ', CAST(N'2020-02-21' AS Date), CAST(N'2020-02-25' AS Date), N'NV01      ', N'H08       ', N'KH01      ', 500000)
INSERT [dbo].[DatPhong] ([MaDP], [NgayDat], [NgayTra], [MaNV], [MaPhong], [MaKH], [TienCoc]) VALUES (N'DP02      ', CAST(N'2020-05-11' AS Date), CAST(N'2020-05-20' AS Date), N'NV01      ', N'B02       ', N'KH02      ', 600000)
INSERT [dbo].[DatPhong] ([MaDP], [NgayDat], [NgayTra], [MaNV], [MaPhong], [MaKH], [TienCoc]) VALUES (N'DP03      ', CAST(N'2020-08-11' AS Date), CAST(N'2020-08-19' AS Date), N'NV02      ', N'A01       ', N'KH01      ', 700000)
INSERT [dbo].[DatPhong] ([MaDP], [NgayDat], [NgayTra], [MaNV], [MaPhong], [MaKH], [TienCoc]) VALUES (N'DP04      ', CAST(N'2021-09-22' AS Date), CAST(N'2021-09-30' AS Date), N'NV04      ', N'D04       ', N'KH04      ', 800000)
INSERT [dbo].[DatPhong] ([MaDP], [NgayDat], [NgayTra], [MaNV], [MaPhong], [MaKH], [TienCoc]) VALUES (N'DP05      ', CAST(N'2021-02-28' AS Date), CAST(N'2010-03-04' AS Date), N'NV05      ', N'G07       ', N'KH01      ', 900000)
INSERT [dbo].[DatPhong] ([MaDP], [NgayDat], [NgayTra], [MaNV], [MaPhong], [MaKH], [TienCoc]) VALUES (N'DP07      ', CAST(N'2021-12-28' AS Date), CAST(N'2021-12-31' AS Date), N'NV02      ', N'I09       ', N'KH03      ', 300000)
INSERT [dbo].[DatPhong] ([MaDP], [NgayDat], [NgayTra], [MaNV], [MaPhong], [MaKH], [TienCoc]) VALUES (N'DP08      ', CAST(N'2021-12-28' AS Date), CAST(N'2021-11-29' AS Date), N'NV02      ', N'E05       ', N'KH01      ', 400000)
INSERT [dbo].[DatPhong] ([MaDP], [NgayDat], [NgayTra], [MaNV], [MaPhong], [MaKH], [TienCoc]) VALUES (N'DP27      ', CAST(N'2021-12-21' AS Date), CAST(N'2021-12-24' AS Date), N'NV02      ', N'P98       ', N'KH14      ', 400000)
INSERT [dbo].[DatPhong] ([MaDP], [NgayDat], [NgayTra], [MaNV], [MaPhong], [MaKH], [TienCoc]) VALUES (N'DP29      ', CAST(N'2021-09-14' AS Date), CAST(N'2021-09-21' AS Date), N'NV02      ', N'P3        ', N'KH93      ', 200000)
INSERT [dbo].[DatPhong] ([MaDP], [NgayDat], [NgayTra], [MaNV], [MaPhong], [MaKH], [TienCoc]) VALUES (N'DP36      ', CAST(N'2021-10-25' AS Date), CAST(N'2021-10-27' AS Date), N'NV02      ', N'Z32       ', N'KH06      ', 200000)
INSERT [dbo].[DatPhong] ([MaDP], [NgayDat], [NgayTra], [MaNV], [MaPhong], [MaKH], [TienCoc]) VALUES (N'DP39      ', CAST(N'2021-10-25' AS Date), CAST(N'2021-11-27' AS Date), N'NV02      ', N'G07       ', N'KH06      ', 200000)
INSERT [dbo].[DatPhong] ([MaDP], [NgayDat], [NgayTra], [MaNV], [MaPhong], [MaKH], [TienCoc]) VALUES (N'DP48      ', CAST(N'2021-12-20' AS Date), CAST(N'2021-12-27' AS Date), N'NV02      ', N'P3        ', N'KH08      ', 200000)
INSERT [dbo].[DatPhong] ([MaDP], [NgayDat], [NgayTra], [MaNV], [MaPhong], [MaKH], [TienCoc]) VALUES (N'DP49      ', CAST(N'2021-12-10' AS Date), CAST(N'2021-12-20' AS Date), N'NV02      ', N'F06       ', N'KH06      ', 500000)
INSERT [dbo].[DatPhong] ([MaDP], [NgayDat], [NgayTra], [MaNV], [MaPhong], [MaKH], [TienCoc]) VALUES (N'DP59      ', CAST(N'2021-12-09' AS Date), CAST(N'2021-12-17' AS Date), N'NV02      ', N'P98       ', N'KH06      ', 400000)
INSERT [dbo].[DatPhong] ([MaDP], [NgayDat], [NgayTra], [MaNV], [MaPhong], [MaKH], [TienCoc]) VALUES (N'DP61      ', CAST(N'2021-12-20' AS Date), CAST(N'2021-12-23' AS Date), N'NV02      ', N'P43       ', N'KH42      ', 300000)
INSERT [dbo].[DatPhong] ([MaDP], [NgayDat], [NgayTra], [MaNV], [MaPhong], [MaKH], [TienCoc]) VALUES (N'DP84      ', CAST(N'2021-12-29' AS Date), CAST(N'2021-12-31' AS Date), N'NV02      ', N'Z32       ', N'KH06      ', 550000)
INSERT [dbo].[DatPhong] ([MaDP], [NgayDat], [NgayTra], [MaNV], [MaPhong], [MaKH], [TienCoc]) VALUES (N'DP85      ', CAST(N'2021-12-13' AS Date), CAST(N'2021-12-15' AS Date), N'NV02      ', N'P17       ', N'KH93      ', 400000)
INSERT [dbo].[DatPhong] ([MaDP], [NgayDat], [NgayTra], [MaNV], [MaPhong], [MaKH], [TienCoc]) VALUES (N'DP89      ', CAST(N'2021-10-26' AS Date), CAST(N'2021-11-30' AS Date), N'NV02      ', N'J10       ', N'KH02      ', 200000)
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [Gia]) VALUES (N'DV01      ', N'Dịch vụ đánh thức', 200000)
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [Gia]) VALUES (N'DV02      ', N'Dịch vụ giặt ủi ', 300000)
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [Gia]) VALUES (N'DV03      ', N'Dịch vụ điểm tâm', 400000)
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [Gia]) VALUES (N'DV04      ', N'Dịch vụ dọn phòng', 500000)
INSERT [dbo].[DichVu] ([MaDV], [TenDV], [Gia]) VALUES (N'DV05      ', N'Dịch vụ massage', 600000)
INSERT [dbo].[DKDichVu] ([MaDK], [MaDV], [MaKH], [Gia], [SLDichVu]) VALUES (N'          ', N'DV05      ', N'KH02      ', 1100000, 2)
INSERT [dbo].[DKDichVu] ([MaDK], [MaDV], [MaKH], [Gia], [SLDichVu]) VALUES (N'DK01      ', N'DV01      ', N'KH01      ', 600000, NULL)
INSERT [dbo].[DKDichVu] ([MaDK], [MaDV], [MaKH], [Gia], [SLDichVu]) VALUES (N'DK02      ', N'DV02      ', N'KH01      ', 1200000, NULL)
INSERT [dbo].[DKDichVu] ([MaDK], [MaDV], [MaKH], [Gia], [SLDichVu]) VALUES (N'DK03      ', N'DV03      ', N'KH01      ', 1200000, NULL)
INSERT [dbo].[DKDichVu] ([MaDK], [MaDV], [MaKH], [Gia], [SLDichVu]) VALUES (N'DK04      ', N'DV04      ', N'KH01      ', 2500000, NULL)
INSERT [dbo].[DKDichVu] ([MaDK], [MaDV], [MaKH], [Gia], [SLDichVu]) VALUES (N'DK05      ', N'DV05      ', N'KH02      ', 1200000, NULL)
INSERT [dbo].[DKDichVu] ([MaDK], [MaDV], [MaKH], [Gia], [SLDichVu]) VALUES (N'DK06      ', N'DV05      ', N'KH01      ', 2000000, 5)
INSERT [dbo].[DKDichVu] ([MaDK], [MaDV], [MaKH], [Gia], [SLDichVu]) VALUES (N'DK07      ', N'DV02      ', N'KH06      ', 500000, 2)
INSERT [dbo].[DKDichVu] ([MaDK], [MaDV], [MaKH], [Gia], [SLDichVu]) VALUES (N'DK09      ', N'DV05      ', N'KH06      ', 800000, 2)
INSERT [dbo].[DKDichVu] ([MaDK], [MaDV], [MaKH], [Gia], [SLDichVu]) VALUES (N'DK10      ', N'DV02      ', N'KH06      ', 500000, 2)
INSERT [dbo].[DKDichVu] ([MaDK], [MaDV], [MaKH], [Gia], [SLDichVu]) VALUES (N'DK100     ', N'DV01      ', N'KH06      ', 200000, 1)
INSERT [dbo].[DKDichVu] ([MaDK], [MaDV], [MaKH], [Gia], [SLDichVu]) VALUES (N'DK24      ', N'DV02      ', N'KH42      ', 500000, 2)
INSERT [dbo].[DKDichVu] ([MaDK], [MaDV], [MaKH], [Gia], [SLDichVu]) VALUES (N'DK25      ', N'DV02      ', N'KH08      ', 300000, 1)
INSERT [dbo].[DKDichVu] ([MaDK], [MaDV], [MaKH], [Gia], [SLDichVu]) VALUES (N'DK63      ', N'DV01      ', N'KH01      ', 200000, 1)
INSERT [dbo].[DKDichVu] ([MaDK], [MaDV], [MaKH], [Gia], [SLDichVu]) VALUES (N'DK82      ', N'DV04      ', N'KH08      ', 900000, 2)
INSERT [dbo].[DKDichVu] ([MaDK], [MaDV], [MaKH], [Gia], [SLDichVu]) VALUES (N'DK90      ', N'DV02      ', N'KH02      ', 500000, 2)
INSERT [dbo].[DKDichVu] ([MaDK], [MaDV], [MaKH], [Gia], [SLDichVu]) VALUES (N'DK94      ', N'DV02      ', N'KH08      ', 300000, 1)
INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [NgaySinh], [GioiTinh], [CCCD], [DiaChi], [Email], [SDT]) VALUES (N'KH01      ', N'Nguyễn Văn Minh', CAST(N'1990-02-12' AS Date), 1, N'079201002121', N'TP Phan Thiết', N'minhnv@gamil.com', N'0903112122')
INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [NgaySinh], [GioiTinh], [CCCD], [DiaChi], [Email], [SDT]) VALUES (N'KH02      ', N'Dương Ngọc Loan', CAST(N'1993-03-13' AS Date), 0, N'079222002121', N'TP Vũng Tàu', N'loandn@gamil.com', N'0903118732')
INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [NgaySinh], [GioiTinh], [CCCD], [DiaChi], [Email], [SDT]) VALUES (N'KH03      ', N'Huỳnh Tấn Dũng', CAST(N'1994-04-22' AS Date), 1, N'079203302121', N'TP Hồ Chí Minh', N'dunght@gamil.com', N'0903102122')
INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [NgaySinh], [GioiTinh], [CCCD], [DiaChi], [Email], [SDT]) VALUES (N'KH04      ', N'Trương Thị Huệ', CAST(N'1996-05-25' AS Date), 0, N'079201502121', N'TP Đà Nẵng', N'huett@gamil.com', N'0903112892')
INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [NgaySinh], [GioiTinh], [CCCD], [DiaChi], [Email], [SDT]) VALUES (N'KH06      ', N'Nguyễn Văn Ba', CAST(N'2021-12-28' AS Date), 1, N'0802121221', N'tp hồ chí minh', N'banv06@gmail.com', N'0912121221')
INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [NgaySinh], [GioiTinh], [CCCD], [DiaChi], [Email], [SDT]) VALUES (N'KH08      ', N'wwww', CAST(N'2021-11-19' AS Date), 1, N'079202009261', N'1', N'tin@gmail.com', N'0901301277')
INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [NgaySinh], [GioiTinh], [CCCD], [DiaChi], [Email], [SDT]) VALUES (N'KH14      ', N'Nông Văn Dũng', CAST(N'2021-12-22' AS Date), 1, N'435234535112', N'tp ho chi minh', N'dwadaw@gmail.com', N'4352345352')
INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [NgaySinh], [GioiTinh], [CCCD], [DiaChi], [Email], [SDT]) VALUES (N'KH42      ', N'Trần Thị Cẩm Loan', CAST(N'1999-12-23' AS Date), 0, N'090921312312', N'TP Hồ Chí Minh', N'loanct123@gmail.com', N'0909213123')
INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [NgaySinh], [GioiTinh], [CCCD], [DiaChi], [Email], [SDT]) VALUES (N'KH84      ', N'Trần Thị Cẩm Tú', CAST(N'1998-12-17' AS Date), 0, N'09123123123', N'tp ho chi minh', N'dadawd@gmail.com', N'0901020212')
INSERT [dbo].[KhachHang] ([MaKH], [HoTen], [NgaySinh], [GioiTinh], [CCCD], [DiaChi], [Email], [SDT]) VALUES (N'KH93      ', N'Nông Văn Tèo', CAST(N'2019-12-13' AS Date), 1, N'0909687212', N'tp hồ chí minh', N'teonv93@gmail.com', N'0909687212')
INSERT [dbo].[NhanVien] ([MaNV], [HoTen], [NgaySinh], [GioiTinh], [CCCD], [DiaChi], [Email], [SDT], [ChucVu]) VALUES (N'NV01      ', N'Nguyễn Văn An', CAST(N'1900-01-01' AS Date), 0, N'', N'', N'', N'', N'')
INSERT [dbo].[NhanVien] ([MaNV], [HoTen], [NgaySinh], [GioiTinh], [CCCD], [DiaChi], [Email], [SDT], [ChucVu]) VALUES (N'NV02      ', N'Huỳnh Thị Nở', CAST(N'2002-12-31' AS Date), 0, N'079109092131', N'Quận 6 TP Hồ Chí Minh', N'noht@gmail.com', N'0901131218', N'Lễ tân')
INSERT [dbo].[NhanVien] ([MaNV], [HoTen], [NgaySinh], [GioiTinh], [CCCD], [DiaChi], [Email], [SDT], [ChucVu]) VALUES (N'NV03      ', N'Nguyễn Văn Dũng', CAST(N'2003-12-31' AS Date), 1, N'079109012121', N'Quận 5 TP Hồ Chí Minh', N'dungnv@gmail.com', N'0201231214', N'Kinh doanh')
INSERT [dbo].[NhanVien] ([MaNV], [HoTen], [NgaySinh], [GioiTinh], [CCCD], [DiaChi], [Email], [SDT], [ChucVu]) VALUES (N'NV04      ', N'Nguyễn Huỳnh Hoa', CAST(N'1999-12-31' AS Date), 0, N'079109292121', N'Quận 10 TP Hồ Chí Minh', N'hoanh@gmail.com', N'0401231211', N'Nhân sự')
INSERT [dbo].[NhanVien] ([MaNV], [HoTen], [NgaySinh], [GioiTinh], [CCCD], [DiaChi], [Email], [SDT], [ChucVu]) VALUES (N'NV05      ', N'Huỳnh Văn Bá', CAST(N'1996-12-31' AS Date), 0, N'079109094121', N'Quận 4 TP Hồ Chí Minh', N'tainv@gmail.com', N'0901931219', N'Kế toán')
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [LoaiPhong], [TinhTrang], [GiaPhong], [MaNV]) VALUES (N'A01       ', N'ABC', N'Giường đơn', N'Phòng trống', 2000000, N'NV01      ')
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [LoaiPhong], [TinhTrang], [GiaPhong], [MaNV]) VALUES (N'B02       ', N'ABCD', N'Giường đôi nhỏ', N'Phòng trống', 1000000, N'NV02      ')
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [LoaiPhong], [TinhTrang], [GiaPhong], [MaNV]) VALUES (N'C03       ', N'ABCDE', N'Giường đôi lớn', N'Phòng trống', 1500000, N'NV03      ')
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [LoaiPhong], [TinhTrang], [GiaPhong], [MaNV]) VALUES (N'D04       ', N'ABCDEF', N'Giường cỡ lớn', N'Phòng trống', 3000000, N'NV04      ')
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [LoaiPhong], [TinhTrang], [GiaPhong], [MaNV]) VALUES (N'E05       ', N'DAWDWAD2A', N'Giường đơn nhỏ', N'Phòng trống', 2000000, N'NV05      ')
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [LoaiPhong], [TinhTrang], [GiaPhong], [MaNV]) VALUES (N'F06       ', N'WWEWEWEWEWE', N'Phòng tiêu chuẩn', N'Phòng đang thuê', 2000000, N'NV02      ')
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [LoaiPhong], [TinhTrang], [GiaPhong], [MaNV]) VALUES (N'G07       ', N'ABCDEFGHN', N' Giường cỡ lớn', N'Phòng trống', 2500000, N'NV02      ')
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [LoaiPhong], [TinhTrang], [GiaPhong], [MaNV]) VALUES (N'H08       ', N'ABCDEFGHE', N'Giường đơn', N'Phòng trống', 2500000, N'NV03      ')
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [LoaiPhong], [TinhTrang], [GiaPhong], [MaNV]) VALUES (N'I09       ', N'AAWDWADADWAD', N'Phòng tiêu chuẩn', N'Phòng đang thuê', 2000000, N'NV05      ')
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [LoaiPhong], [TinhTrang], [GiaPhong], [MaNV]) VALUES (N'J10       ', N'Cánh đồng thơm mát', N'Phòng tiêu chuẩn', N'Phòng trống', 1300000, N'NV02      ')
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [LoaiPhong], [TinhTrang], [GiaPhong], [MaNV]) VALUES (N'P01       ', N'ABC', N'Phòng tiêu chuẩn', N'Phòng trống', 2000000, N'NV01      ')
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [LoaiPhong], [TinhTrang], [GiaPhong], [MaNV]) VALUES (N'P02       ', N'ABCD', N'Giường đôi nhỏ', N'Phòng trống', 1000000, N'NV02      ')
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [LoaiPhong], [TinhTrang], [GiaPhong], [MaNV]) VALUES (N'P04       ', N'ABCDEF', N'Phòng tiêu chuẩn', N'Phòng đã đặt trước', 3000000, N'NV04      ')
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [LoaiPhong], [TinhTrang], [GiaPhong], [MaNV]) VALUES (N'P06       ', N'ABCDEFGHK', N'Giường đôi nhỏ', N'Phòng trống', 2000000, N'NV01      ')
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [LoaiPhong], [TinhTrang], [GiaPhong], [MaNV]) VALUES (N'P07       ', N'ABCDEFGHN', N' Giường cỡ lớn', N'Phòng trống', 2500000, N'NV02      ')
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [LoaiPhong], [TinhTrang], [GiaPhong], [MaNV]) VALUES (N'P08       ', N'ABCDEFGHE', N'Giường đơn', N'Phòng trống', 2500000, N'NV03      ')
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [LoaiPhong], [TinhTrang], [GiaPhong], [MaNV]) VALUES (N'P09       ', N'AAWDWADADWAD', N'Phòng tiêu chuẩn', N'Phòng trống', 2000000, N'NV05      ')
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [LoaiPhong], [TinhTrang], [GiaPhong], [MaNV]) VALUES (N'P10       ', N'A', N'Phòng tiêu chuẩn', N'Phòng trống', 2000000, N'NV02      ')
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [LoaiPhong], [TinhTrang], [GiaPhong], [MaNV]) VALUES (N'P12       ', N'BLG', N'Phòng tiêu chuẩn', N'Phòng trống', 3000000, N'NV03      ')
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [LoaiPhong], [TinhTrang], [GiaPhong], [MaNV]) VALUES (N'P17       ', N'Mis', N'Giường đôi nhỏ', N'Phòng trống', 2000000, N'NV03      ')
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [LoaiPhong], [TinhTrang], [GiaPhong], [MaNV]) VALUES (N'P23       ', N'byy7', N'Giường đôi lớn', N'PHÒNG TRỐNG', 2000000, N'NV02      ')
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [LoaiPhong], [TinhTrang], [GiaPhong], [MaNV]) VALUES (N'P29       ', N'SSW', N'Giường đôi lớn', N'Phòng trống', 2500000, N'NV03      ')
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [LoaiPhong], [TinhTrang], [GiaPhong], [MaNV]) VALUES (N'P3        ', N'Masster', N'Giường đơn nhỏ', N'Phòng trống', 1000000, N'NV03      ')
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [LoaiPhong], [TinhTrang], [GiaPhong], [MaNV]) VALUES (N'P32       ', N'QWESADXZXX', N'Giường đơn', N'Phòng đang thuê', 1200000, N'NV04      ')
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [LoaiPhong], [TinhTrang], [GiaPhong], [MaNV]) VALUES (N'P40       ', N'msiiii', N'Giường đơn nhỏ', N'Phòng trống', 1000000, N'NV03      ')
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [LoaiPhong], [TinhTrang], [GiaPhong], [MaNV]) VALUES (N'P43       ', N'SKT', N'Giường đơn lớn', N'Phòng trống', 1500000, N'NV03      ')
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [LoaiPhong], [TinhTrang], [GiaPhong], [MaNV]) VALUES (N'P80       ', N'MSI', N'Giường đơn nhỏ', N'Phòng trống', 2000000, N'NV03      ')
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [LoaiPhong], [TinhTrang], [GiaPhong], [MaNV]) VALUES (N'P98       ', N'MASW', N'Giường đôi nhỏ', N'Phòng đang thuê', 2000000, N'NV03      ')
INSERT [dbo].[Phong] ([MaPhong], [TenPhong], [LoaiPhong], [TinhTrang], [GiaPhong], [MaNV]) VALUES (N'Z32       ', N'QWESADXZXX', N'Giường đơn', N'Phòng trống', 1200000, N'NV04      ')
INSERT [dbo].[TaiKhoan] ([TenTK], [MatKhau], [ChucVu], [MaNV]) VALUES (N'abc', N'123', N'Kinh doanh', N'NV01      ')
INSERT [dbo].[TaiKhoan] ([TenTK], [MatKhau], [ChucVu], [MaNV]) VALUES (N'dung', N'789', N'Kinh doanh', N'NV03      ')
INSERT [dbo].[TaiKhoan] ([TenTK], [MatKhau], [ChucVu], [MaNV]) VALUES (N'hoa', N'101112', N'Nhân sự', N'NV04      ')
INSERT [dbo].[TaiKhoan] ([TenTK], [MatKhau], [ChucVu], [MaNV]) VALUES (N'no', N'456', N'Lễ tân', N'NV02      ')
INSERT [dbo].[TaiKhoan] ([TenTK], [MatKhau], [ChucVu], [MaNV]) VALUES (N'tai', N'123', N'Kế toán', N'NV05      ')
INSERT [dbo].[TaiKhoan] ([TenTK], [MatKhau], [ChucVu], [MaNV]) VALUES (N'teo', N'123', N'Kế toán', N'NV01      ')
INSERT [dbo].[TaiKhoan] ([TenTK], [MatKhau], [ChucVu], [MaNV]) VALUES (N'tin', N'1234', N'Kinh doanh', N'NV04      ')
SET IDENTITY_INSERT [dbo].[ThanhToan] ON 

INSERT [dbo].[ThanhToan] ([MaTT], [MaDK], [MaDP], [MaNV], [MaKH], [ThanhTien]) VALUES (1, N'DK01      ', N'DP01      ', N'NV01      ', N'KH01      ', 10000000)
INSERT [dbo].[ThanhToan] ([MaTT], [MaDK], [MaDP], [MaNV], [MaKH], [ThanhTien]) VALUES (2, N'DK02      ', N'DP01      ', N'NV01      ', N'KH02      ', 12000000)
INSERT [dbo].[ThanhToan] ([MaTT], [MaDK], [MaDP], [MaNV], [MaKH], [ThanhTien]) VALUES (3, N'DK03      ', N'DP03      ', N'NV01      ', N'KH03      ', 13000000)
INSERT [dbo].[ThanhToan] ([MaTT], [MaDK], [MaDP], [MaNV], [MaKH], [ThanhTien]) VALUES (4, N'DK04      ', N'DP04      ', N'NV01      ', N'KH04      ', 14000000)
INSERT [dbo].[ThanhToan] ([MaTT], [MaDK], [MaDP], [MaNV], [MaKH], [ThanhTien]) VALUES (6, N'DK07      ', N'DP49      ', N'NV02      ', N'KH06      ', 20000000)
INSERT [dbo].[ThanhToan] ([MaTT], [MaDK], [MaDP], [MaNV], [MaKH], [ThanhTien]) VALUES (7, N'DK05      ', N'DP08      ', N'NV02      ', N'KH01      ', 12000000)
INSERT [dbo].[ThanhToan] ([MaTT], [MaDK], [MaDP], [MaNV], [MaKH], [ThanhTien]) VALUES (8, N'DK02      ', N'DP07      ', N'NV03      ', N'KH03      ', 13000000)
INSERT [dbo].[ThanhToan] ([MaTT], [MaDK], [MaDP], [MaNV], [MaKH], [ThanhTien]) VALUES (16, N'DK10      ', N'DP84      ', N'NV02      ', N'KH06      ', 2350000)
INSERT [dbo].[ThanhToan] ([MaTT], [MaDK], [MaDP], [MaNV], [MaKH], [ThanhTien]) VALUES (17, N'DK100     ', N'DP84      ', N'NV02      ', N'KH06      ', 2050000)
INSERT [dbo].[ThanhToan] ([MaTT], [MaDK], [MaDP], [MaNV], [MaKH], [ThanhTien]) VALUES (18, N'DK100     ', N'DP84      ', N'NV02      ', N'KH06      ', 2050000)
INSERT [dbo].[ThanhToan] ([MaTT], [MaDK], [MaDP], [MaNV], [MaKH], [ThanhTien]) VALUES (19, N'DK100     ', N'DP84      ', N'NV02      ', N'KH06      ', 2050000)
INSERT [dbo].[ThanhToan] ([MaTT], [MaDK], [MaDP], [MaNV], [MaKH], [ThanhTien]) VALUES (1020, N'DK90      ', N'DP89      ', N'NV02      ', N'KH02      ', 45800000)
INSERT [dbo].[ThanhToan] ([MaTT], [MaDK], [MaDP], [MaNV], [MaKH], [ThanhTien]) VALUES (1021, N'DK82      ', N'DP48      ', N'NV02      ', N'KH08      ', 7700000)
INSERT [dbo].[ThanhToan] ([MaTT], [MaDK], [MaDP], [MaNV], [MaKH], [ThanhTien]) VALUES (1022, N'          ', N'DP85      ', N'NV02      ', N'KH93      ', 3600000)
INSERT [dbo].[ThanhToan] ([MaTT], [MaDK], [MaDP], [MaNV], [MaKH], [ThanhTien]) VALUES (1023, N'          ', N'DP27      ', N'NV02      ', N'KH14      ', 5600000)
INSERT [dbo].[ThanhToan] ([MaTT], [MaDK], [MaDP], [MaNV], [MaKH], [ThanhTien]) VALUES (1024, N'DK24      ', N'DP61      ', N'NV02      ', N'KH42      ', 4700000)
INSERT [dbo].[ThanhToan] ([MaTT], [MaDK], [MaDP], [MaNV], [MaKH], [ThanhTien]) VALUES (1025, N'DK100     ', N'DP84      ', N'NV02      ', N'KH06      ', 9250000)
SET IDENTITY_INSERT [dbo].[ThanhToan] OFF
ALTER TABLE [dbo].[DatPhong]  WITH CHECK ADD  CONSTRAINT [FK_DatPhong_KhachHang] FOREIGN KEY([MaKH])
REFERENCES [dbo].[KhachHang] ([MaKH])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[DatPhong] CHECK CONSTRAINT [FK_DatPhong_KhachHang]
GO
ALTER TABLE [dbo].[DatPhong]  WITH CHECK ADD  CONSTRAINT [FK_DatPhong_NhanVien] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[DatPhong] CHECK CONSTRAINT [FK_DatPhong_NhanVien]
GO
ALTER TABLE [dbo].[DatPhong]  WITH CHECK ADD  CONSTRAINT [FK_DatPhong_Phong] FOREIGN KEY([MaPhong])
REFERENCES [dbo].[Phong] ([MaPhong])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[DatPhong] CHECK CONSTRAINT [FK_DatPhong_Phong]
GO
ALTER TABLE [dbo].[DKDichVu]  WITH CHECK ADD  CONSTRAINT [FK_DKDichVu_DichVu] FOREIGN KEY([MaDV])
REFERENCES [dbo].[DichVu] ([MaDV])
GO
ALTER TABLE [dbo].[DKDichVu] CHECK CONSTRAINT [FK_DKDichVu_DichVu]
GO
ALTER TABLE [dbo].[DKDichVu]  WITH CHECK ADD  CONSTRAINT [FK_DKDichVu_KhachHang] FOREIGN KEY([MaKH])
REFERENCES [dbo].[KhachHang] ([MaKH])
GO
ALTER TABLE [dbo].[DKDichVu] CHECK CONSTRAINT [FK_DKDichVu_KhachHang]
GO
ALTER TABLE [dbo].[Phong]  WITH CHECK ADD  CONSTRAINT [FK_Phong_NhanVien] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[Phong] CHECK CONSTRAINT [FK_Phong_NhanVien]
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [FK_TaiKhoan_NhanVien] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [FK_TaiKhoan_NhanVien]
GO
ALTER TABLE [dbo].[ThanhToan]  WITH CHECK ADD  CONSTRAINT [FK_ThanhToan_DatPhong] FOREIGN KEY([MaDP])
REFERENCES [dbo].[DatPhong] ([MaDP])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[ThanhToan] CHECK CONSTRAINT [FK_ThanhToan_DatPhong]
GO
ALTER TABLE [dbo].[ThanhToan]  WITH CHECK ADD  CONSTRAINT [FK_ThanhToan_DKDichVu] FOREIGN KEY([MaDK])
REFERENCES [dbo].[DKDichVu] ([MaDK])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ThanhToan] CHECK CONSTRAINT [FK_ThanhToan_DKDichVu]
GO
ALTER TABLE [dbo].[ThanhToan]  WITH CHECK ADD  CONSTRAINT [FK_ThanhToan_KhachHang] FOREIGN KEY([MaKH])
REFERENCES [dbo].[KhachHang] ([MaKH])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[ThanhToan] CHECK CONSTRAINT [FK_ThanhToan_KhachHang]
GO
ALTER TABLE [dbo].[ThanhToan]  WITH CHECK ADD  CONSTRAINT [FK_ThanhToan_NhanVien] FOREIGN KEY([MaNV])
REFERENCES [dbo].[NhanVien] ([MaNV])
GO
ALTER TABLE [dbo].[ThanhToan] CHECK CONSTRAINT [FK_ThanhToan_NhanVien]
GO
/****** Object:  StoredProcedure [dbo].[CheckDKDV]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[CheckDKDV]
(@maKH nchar(10))
as
	begin
		select * from DKDichVu where MaKH=@maKH
	end
GO
/****** Object:  StoredProcedure [dbo].[CheckTK]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[CheckTK]
(@maNV nchar(10))
as
	begin
		select*from TaiKhoan where MaNV = @maNV
	end
GO
/****** Object:  StoredProcedure [dbo].[checkTT]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[checkTT]
(@maDP nvarchar(50))
as
	begin
		select * from ThanhToan where MaDP = @maDP
	end
GO
/****** Object:  StoredProcedure [dbo].[DangNhap]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[DangNhap]
(@tenTK varchar(50)=null ,@matKhau varchar(50)=null)
as
	begin
		if (@tenTK is null) or (@matKhau is null)
			begin
				print N'Tên tài khoản và mật khẩu không được để trống'
				return 0;
			end
		else
			begin
				if not exists (select * from TaiKhoan where TenTK = @tenTK and MatKhau = @matKhau)
					begin
						print N'Sai tên tài khoản hoặc mật khẩu';
						return -1;
					end	
				else
					begin
						print N'Bạn đã đăng nhập thành công!!!';
						return 1;
					end
			end
	end
GO
/****** Object:  StoredProcedure [dbo].[Delete_dangkydichvu]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[Delete_dangkydichvu]
(@MaDK NCHAR(10))
as
	begin
		DELETE FROM DKDichVu WHERE MaDK = @MaDK
	end
GO
/****** Object:  StoredProcedure [dbo].[Delete_datphong]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[Delete_datphong]
(@MaDatPhong NCHAR(10))
as
	begin
		DELETE FROM DatPhong WHERE MaDP =@MaDatPhong
	end
GO
/****** Object:  StoredProcedure [dbo].[Delete_dichvu]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[Delete_dichvu]
(@MaDV NCHAR(10))
as
	begin
		DELETE FROM DichVu WHERE MaDV = @MaDV
	end
GO
/****** Object:  StoredProcedure [dbo].[Delete_khachhang]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[Delete_khachhang]
(@MaKH NCHAR(10))
as
	begin
		DELETE FROM KhachHang WHERE MaKH = @MaKH
	end
GO
/****** Object:  StoredProcedure [dbo].[Delete_NhanVien]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[Delete_NhanVien]
(@MaNV nchar(10))
as
	begin
		DELETE FROM NhanVien WHERE MaNV = @MaNV
	end
GO
/****** Object:  StoredProcedure [dbo].[Delete_PHONG]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[Delete_PHONG]
(@MaPhong nchar(10))
as
	begin
		DELETE FROM Phong WHERE MaPhong = @MaPhong
	end
GO
/****** Object:  StoredProcedure [dbo].[Delete_TaiKhoan]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[Delete_TaiKhoan]
(@TenTK varchar(50))
as
	begin
		DELETE FROM TaiKhoan WHERE TenTK=@TenTK
	end
GO
/****** Object:  StoredProcedure [dbo].[Delete_ThanhToan]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[Delete_ThanhToan]
(@MaDK nchar(10),@MaDP nchar(10),@MaNV nchar(10),@MaKH nchar(10),@ThanhTien float,@MaTT int)
as
	begin
		DELETE FROM ThanhToan WHERE MaTT = @MaTT
	end
GO
/****** Object:  StoredProcedure [dbo].[Find_DatPhong]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[Find_DatPhong]
(@maDP nchar(50))
as
	begin
		select*from DatPhong where MaDP = @maDP
	end
GO
/****** Object:  StoredProcedure [dbo].[Find_DichVu]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[Find_DichVu]
(@maDV nchar(10))
as
	begin
		select * from DichVu where MaDV like @maDV
	end
GO
/****** Object:  StoredProcedure [dbo].[Find_DKDichVu]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[Find_DKDichVu]
(@MaDK nchar(10))
as
			begin
				select * from DKDichVu where MaDK LIKE @MaDK 
				return 1;
			end
GO
/****** Object:  StoredProcedure [dbo].[Find_KhachHang]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[Find_KhachHang]
(@maKH nchar(50)=null)
as
		begin
					select * from KhachHang where MaKH = @maKH
		end
GO
/****** Object:  StoredProcedure [dbo].[Find_List_ThanhToan]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[Find_List_ThanhToan]
(@MaTT INT=null,@MaDP nchar(10)=null,@selecttype int)
as
	begin
		if(@selecttype=0)
			begin
				select*from ThanhToan
			end
		if(@selecttype=1)
			begin
				select * from ThanhToan where MaTT LIKE @MaTT or MaDP LIKE @MaDP
				return 1;
			end
	end
GO
/****** Object:  StoredProcedure [dbo].[Find_NhanVien]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[Find_NhanVien]
(@maNV nchar(50)=null,@hoten nvarchar(50)=null,@cccd varchar(12)=null,@sdt varchar(12)=null)
as
	begin
		select * from NhanVien where MaNV = @maNV or  HoTen like @hoten or CCCD like @cccd or SDT like @sdt
		return 1;
	end
GO
/****** Object:  StoredProcedure [dbo].[Find_NhanVienByID]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[Find_NhanVienByID]
(@maNV nchar(50))
as
	begin
		select*from NhanVien where MaNV = @maNV
	end
GO
/****** Object:  StoredProcedure [dbo].[Find_PHONG]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[Find_PHONG]
(@maPhong nchar(50))
as
	begin
		select * from Phong where MaPhong = @maPhong
	end
GO
/****** Object:  StoredProcedure [dbo].[Find_TaiKhoan]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[Find_TaiKhoan]
(@tenTK varchar(50))
as
	begin
		select * from TaiKhoan where TenTK like @tenTK
		return 1;
	end
GO
/****** Object:  StoredProcedure [dbo].[Find_ThanhToan]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[Find_ThanhToan]
(@MaTT INT,@MaDP nchar(10))
as
	begin
		if  not exists(select * from ThanhToan where MaTT=@MaTT or MaDP=@MaDP )
			begin
				print N'Không tìm thấy thông tin hóa đơn này!!';
				return 0;
			end
		else
			begin
				select * from ThanhToan where MaTT LIKE @MaTT or MaDP LIKE @MaDP
				return 1;
			end
	end
GO
/****** Object:  StoredProcedure [dbo].[FindPhong_InDatPhong]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[FindPhong_InDatPhong]
(@maPhong nchar(50))
as
	begin
		select*from DatPhong where MaPhong = @maPhong
	end
GO
/****** Object:  StoredProcedure [dbo].[Insert_dangkydichvu]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[Insert_dangkydichvu]
(@MaDK NCHAR(10)=null,@MaDV NCHAR(10)=null,@MaKH NCHAR(10)=null,@Gia FLOAT=null,@SoLuongDV INT=null)
as
	begin
		if(@MaDK is null or @SoLuongDV is null or @MaDV is null or @MaKH is  null or @Gia is null)
			begin
				print N'Các trường dữ liệu không được để trống';
				return 0;
			end
		else if exists (select* from DKDichVu where @MaDK = MaDK)
			begin
				print N'Trùng mã đăng ký dịch vụ';
				return -1;
			end
		else
			begin
				INSERT INTO DKDichVu(MaDK,MaDV,MaKH,Gia,SLDichVu) VALUES (@MaDK,@MaDV,@MaKH,@Gia,@SoLuongDV)
				return 1;
			end
	end
GO
/****** Object:  StoredProcedure [dbo].[Insert_datphong]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[Insert_datphong]
(@MaDatPhong NCHAR(10)=null,@NgayDat DATE=null,@NgayTra DATE=null,@MaNV NCHAR(10)=null,@MaPhong NCHAR(10)=null,@MaKH NCHAR(10)=null,@TienCoc FLOAT=null)
as
	begin
		if(@MaDatPhong is null or @NgayDat is null or @NgayTra is null or @MaNV is null or @MaPhong is null or @MaKH is null or @TienCoc is null)
			begin
				print N'Các trường dữ liệu không được để trống';
				return 0;
			end
		else if exists (select* from DatPhong where MaDP = @MaDatPhong)
			begin
				print N'Trùng mã đặt phòng';
				return -1;
			end
		else
			begin
				INSERT INTO DatPhong (MaDP,NgayDat,NgayTra,MaNV,MaPhong,MaKH,TienCoc) VALUES (@MaDatPhong,@NgayDat,@NgayTra,@MaNV,@MaPhong,@MaKH,@TienCoc)
				return 1;
			end
	end
GO
/****** Object:  StoredProcedure [dbo].[Insert_dichvu]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[Insert_dichvu]
(@MaDV NCHAR(10)=null,@TenDV NVARCHAR(50)=null,@Gia FLOAT=null)
as
	begin
		if(@MaDV is null or @TenDV is null or @Gia is null)
			begin
				print N'Các trường dữ liệu không được để trống';
				return 0;
			end
		else if exists (select* from DichVu where @MaDV = MaDV)
			begin
				print N'Trùng mã dịch vụ';
				return -1;
			end
		else
			begin
				INSERT INTO DichVu(MaDV,TenDV,Gia) VALUES (@MaDV,@TenDV,@Gia)
				return 1;
			end
	end
GO
/****** Object:  StoredProcedure [dbo].[Insert_khachhang]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[Insert_khachhang]
(@MaKH NCHAR(10)=null,@HoTen NVARCHAR(50)=null,@NgaySinh DATE=null,@GioiTinh BIT=null,@CCCD VARCHAR(12)=null,@DiaChi NVARCHAR(100)=null,@Email VARCHAR(50)=null,@Sdt VARCHAR(12)=null)
as
	begin
		if (@MaKH is null or @HoTen is null or @NgaySinh  is null or @GioiTinh is null or @CCCD is null or @DiaChi is null or @Email is null or @Sdt is null)
			begin
				print N'Các trường dữ liệu không được để trống';
				return 0;
			end
		else if exists (select*from KhachHang where MaKH = @MaKH)
			begin
				print N'Trùng mã khách hàng';
				return -1;
			end
		else
			begin
				INSERT INTO KhachHang (MaKH,HoTen,NgaySinh,GioiTinh,CCCD,DiaChi,Email,SDT) VALUES (@MaKH,@HoTen,@NgaySinh,@GioiTinh,@CCCD,@DiaChi,@Email,@Sdt)
				return 1;
			end
	end
GO
/****** Object:  StoredProcedure [dbo].[insert_NhanVien]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[insert_NhanVien]
(@MaNV nchar(10)=null,@HoTen nvarchar(50)=null,@NgaySinh date=null,@GioiTinh bit=null,@CCCD varchar(12)=null,@DiaChi nvarchar(100)=null,@Email varchar(50)=null,@SoDienThoai varchar(12)=null,@ChucVu nvarchar(20)=null)
as
	begin
		if(@MaNV is null or @HoTen is null or @NgaySinh  is null or @GioiTinh is null or @CCCD  is null or @DiaChi is null or @Email is null or @SoDienThoai is null or @ChucVu is null)
			begin
				print N'Các trường dữ liệu không được để trống';
				return 0;
			end
		else if exists (select*from NhanVien where MaNV  = @MaNV)
			begin
				print N'Trùng mã nhân viên';
				return -1;
			end
		else
			begin
				INSERT INTO NhanVien (MaNV,HoTen,NgaySinh,GioiTinh,CCCD,DiaChi,Email,SDT,ChucVu) VALUES (@MaNV,@HoTen,@NgaySinh,@GioiTinh,@CCCD,@DiaChi,@Email,@SoDienThoai,@ChucVu)
				print N'Thêm thành công';
				return 1;
			end
	end
GO
/****** Object:  StoredProcedure [dbo].[insert_PHONG]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[insert_PHONG]
(@MaPhong nchar(10)=null,@TenPhong nvarchar(20)=null,@LoaiPhong nvarchar(20)=null,@TinhTrang nvarchar(20)=null,@GiaPhong float=null,@MaNV nchar(10)=null)
as
	begin
		if(@MaPhong is null or @TenPhong is null or @LoaiPhong is null or @TinhTrang is null or @GiaPhong is null or @MaNV  is null )
			begin
				print N'Các trường dữ liệu không được để trống';
				return 0;
			end
		else if exists (select* from phong where MaPhong = @MaPhong)
			begin
				print N'Trùng mã phòng';
				return -1;
			end
		else
			begin
				INSERT INTO Phong (MaPhong,TenPhong,LoaiPhong,TinhTrang,GiaPhong,MaNV) VALUES (@MaPhong,@TenPhong,@LoaiPhong,@TinhTrang,@GiaPhong,@MaNV)
				return 1;
			end
	end
GO
/****** Object:  StoredProcedure [dbo].[insert_TaiKhoan]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[insert_TaiKhoan]
(@TenTK varchar(50)=null,@MatKhau varchar(50)=null,@ChucVu nvarchar(10)=null,@MaNV nchar(10)=null)
as
	begin
		if(@TenTK is null or @MatKhau is null or @ChucVu is null or @MaNV is null)
			begin
				print N'Các trường dữ liệu không được để trống';
				return 0;
			end
		else if exists (select * from TaiKhoan where TenTK = @TenTK )
			begin
				print N'Tên đăng nhập này đã có người sử dụng';
				return 0;
			end
		else
			begin
				INSERT INTO TaiKhoan(TenTK,MatKhau,ChucVu,MaNV) VALUES (@TenTK,@MatKhau,@ChucVu,@MaNV);
				return 1;
			end
	end
GO
/****** Object:  StoredProcedure [dbo].[insert_ThanhToan]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[insert_ThanhToan]
(@MaDK nchar(10)=null,@MaDP nchar(10)=null,@MaNV nchar(10)=null,@MaKH nchar(10)=null,@ThanhTien float=null)
as
	begin
		if(@MaDK is null or @MaDP is null or @MaNV is null or @MaKH is null or @ThanhTien is null)
			begin
				print N'Các trường dữ liệu không được để trống';
				return 0;
			end
		else
			begin
				INSERT INTO ThanhToan(MaDK,MaDP,MaNV,MaKH,ThanhTien) VALUES (@MaDK,@MaDP,@MaNV,@MaKH,@ThanhTien)
				return 1;
			end
	end
GO
/****** Object:  StoredProcedure [dbo].[LaySoNgayO]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[LaySoNgayO]
(@maKH nchar(50))
as
	begin
		select datediff(day,NgayDat,NgayTra) as SoNgayO from DatPhong where MaKH=@maKH
	end
GO
/****** Object:  StoredProcedure [dbo].[List_DatPhong]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[List_DatPhong]
as
	begin
		select * from DatPhong
	end
GO
/****** Object:  StoredProcedure [dbo].[List_DichVu]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[List_DichVu]
as
	begin
		select * from DichVu
	end
GO
/****** Object:  StoredProcedure [dbo].[List_DKDichVu]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[List_DKDichVu]
as
	begin
		select * from DKDichVu
	end

GO
/****** Object:  StoredProcedure [dbo].[List_Find_DKDichVu]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[List_Find_DKDichVu]
(@listtype int,@MaDK nchar(10),@MaDV nchar(10),@MaKH nchar(10))
as
	begin
		if(@listtype=0)
			begin
				select * from DKDichVu
			end
		if(@listtype=1)
			begin
				select MaDK,MaKH,MaDV,Gia,SLDichVu from DKDichVu where MaDK like @MaDK or MaDV like @MaDV or MaKH like @MaKH
			end
	end
GO
/****** Object:  StoredProcedure [dbo].[List_Find_NhanVien]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[List_Find_NhanVien]
(@maNV nchar(50),@hoten nvarchar(50),@cccd nchar(50),@sdt nchar(50),@selecttype int)
as
	begin
		if (@maNV is null and @hoten is null and @cccd is null and @sdt is  null)
			begin
				print N'Các trường dữ liệu không đươc để trống';
				return 0;
			end
		else if(@selecttype=0)
			begin
				select*from NhanVien;
			end
		else if(@selecttype=1)
			begin
				select * from NhanVien where MaNV = @maNV or HoTen like @hoten or CCCD like @cccd or SDT like @sdt
				return 1;
			end
	end
GO
/****** Object:  StoredProcedure [dbo].[List_Find_Phong]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[List_Find_Phong]
(@maPhong nchar(10)=null,@tenPhong nvarchar(20)=null,@selecttype int)
as
	begin
		if(@selecttype=0)
			begin
				select*from Phong
			end
		if(@selecttype=1)
			begin
				select*from Phong where MaPhong=@maPhong or TenPhong like @tenPhong
			end
	end
GO
/****** Object:  StoredProcedure [dbo].[List_Find_ThanhToan]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[List_Find_ThanhToan]
(@selecttype int,@maTT int)
as
	begin
		if(@selecttype=0)
			begin
				select*from ThanhToan
			end
		if(@selecttype=1)
			begin
				select*from ThanhToan where MaTT like @maTT
			end
	end
GO
/****** Object:  StoredProcedure [dbo].[List_KhachHang]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[List_KhachHang]
as
	begin
		select * from KhachHang
	end
GO
/****** Object:  StoredProcedure [dbo].[List_MaDatPhongTheoKhachHang]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[List_MaDatPhongTheoKhachHang]
(@maKH nchar(50))
as
	begin
		select*from DatPhong where MaKH = @maKH
	end
GO
/****** Object:  StoredProcedure [dbo].[List_MaDKTheoKhachHang]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[List_MaDKTheoKhachHang]
(@maKH nchar(50))
as
	begin
		 select * from DKDichVu where MaKH = @maKH
	end
GO
/****** Object:  StoredProcedure [dbo].[List_MaKhacHang]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[List_MaKhacHang]
as
	begin
		select distinct MaKH from KhachHang  order by MaKH 
	end
GO
/****** Object:  StoredProcedure [dbo].[List_NhanVien]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[List_NhanVien]
as
	begin
		select * from NhanVien
	end

GO
/****** Object:  StoredProcedure [dbo].[List_PHONG]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[List_PHONG]
as
	begin
		select * from Phong
	end
GO
/****** Object:  StoredProcedure [dbo].[List_PHONGDADAT]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[List_PHONGDADAT]
@TinhTrang nvarchar(50)
as
	begin
		select dp.madp,dp.ngaydat,dp.ngaytra,dp.manv,dp.MaPhong,dp.makh,tiencoc from DatPhong dp
				join Phong p  on dp.MaPhong=p.MaPhong 
			where TinhTrang like @TinhTrang
	end
GO
/****** Object:  StoredProcedure [dbo].[List_PHONGDANGTHUE]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[List_PHONGDANGTHUE]
@TinhTrang nvarchar(50)
as
	begin
		select dp.MaDP,dp.NgayDat,dp.NgayTra,dp.MaNV,p.MaPhong,dp.MaKH from DatPhong dp
		join Phong p on dp.MaPhong=p.MaPhong where p.TinhTrang like @TinhTrang
	end
GO
/****** Object:  StoredProcedure [dbo].[List_PHONGTRONG]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[List_PHONGTRONG]
@TinhTrang nvarchar(50)
as
	begin
		select MaPhong,TenPhong,LoaiPhong,GiaPhong from Phong where TinhTrang like @TinhTrang
	end
GO
/****** Object:  StoredProcedure [dbo].[List_TaiKhoan]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[List_TaiKhoan]
as
	begin
			select * from TaiKhoan
	end
GO
/****** Object:  StoredProcedure [dbo].[List_ThanhToan]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[List_ThanhToan]
as
	begin
		select * from ThanhToan
	end
GO
/****** Object:  StoredProcedure [dbo].[select_MaDP_TienCocByMaKH]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create  proc  [dbo].[select_MaDP_TienCocByMaKH]
(@selecttype int,@maKH nchar(50))
as
	begin
		-- 0 là  lấy mã đặt phòng
		if(@selecttype = 0)
			begin
				select MaDP from DatPhong where MaKH =  @maKH
			end
		-- 1 là lấy tiền cọc
		if(@selecttype = 1)
			begin
				select tiencoc from DatPhong where MaKH =  @maKH
			end
	end
GO
/****** Object:  StoredProcedure [dbo].[selectbyKeyWordDichVu]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[selectbyKeyWordDichVu]
(@MaDV nchar(10),@TenDV nvarchar(50))
as
begin
 	Select * from DichVu where MaDV like @MaDV or TenDV like @TenDV
end 
GO
/****** Object:  StoredProcedure [dbo].[SelectbyKeyWordDKDichVu]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[SelectbyKeyWordDKDichVu]
(@MaDK nchar(10),@MaDV nchar(10), @MaKH nchar(10))
as
	begin
		select MaDK,MaKH,MaDV,Gia,SLDichVu from DKDichVu where MaDK like @MaDK or MaDV like @MaDV or MaKH like @MaKH
	end
GO
/****** Object:  StoredProcedure [dbo].[selectbyKeyWordKhachHang]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[selectbyKeyWordKhachHang]
(@MaKH nchar(10),@hoTen nvarchar(50),@CCCD varchar(12))
as
begin
 	Select * from KhachHang where MaKH like @MaKH or HoTen like @hoTen or CCCD like @CCCD
end  
GO
/****** Object:  StoredProcedure [dbo].[selectbyKeyWordPhong]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[selectbyKeyWordPhong]
(@MaPhong nchar(10),@TenPhong nvarchar(20),@LoaiPhong nvarchar(20))
as
begin
 	Select * from Phong where  MaPhong like @MaPhong or TenPhong like @TenPhong or LoaiPhong like @LoaiPhong
end 
GO
/****** Object:  StoredProcedure [dbo].[selectbyKeyWordTaiKhoan]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[selectbyKeyWordTaiKhoan]
(@TenTK varchar(50))
as
begin
 	Select * from TaiKhoan where TenTK like @TenTK
end  
GO
/****** Object:  StoredProcedure [dbo].[selectbyKeyWordThanhToan]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[selectbyKeyWordThanhToan]
(@MaDP nchar(10))
as
begin
 	Select * from ThanhToan where MaDP like @MaDP
end  
GO
/****** Object:  StoredProcedure [dbo].[selectbyKw]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[selectbyKw]
(@MaNV nchar(10),@HoTen nvarchar(50),@CCCD varchar(12),@SDT varchar(10))
as
begin
 	Select * from NhanVien where MaNV like @MaNV or HoTen like @HoTen or CCCD like @CCCD or SDT like @SDT
end   
GO
/****** Object:  StoredProcedure [dbo].[selectDay]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[selectDay]
as
begin
	SELECT DISTINCT day(NgayDat) Day FROM DatPhong ORDER BY Day DESC
end
GO
/****** Object:  StoredProcedure [dbo].[SelectGiaByDV]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[SelectGiaByDV]
(@maDV nchar(50))
as
	begin
		select Gia from DichVu where MaDV = @MaDV 
	end
GO
/****** Object:  StoredProcedure [dbo].[SelectGiaPhongByMaDP]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[SelectGiaPhongByMaDP]
(@madp nchar(50))
as
	begin
			select p.GiaPhong from DatPhong dp
				join Phong p on dp.MaPhong=p.MaPhong where dp.MaDP = @madp
	end
GO
/****** Object:  StoredProcedure [dbo].[selectKeyWordByPhongTrong]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[selectKeyWordByPhongTrong]
(@maPhong nchar(50),@tinhtrang nchar(10))
as
	begin
		select maphong,tenphong,loaiphong,giaphong from Phong where MaPhong=@maPhong and TinhTrang like @tinhtrang 
	end
GO
/****** Object:  StoredProcedure [dbo].[selectMaDKByMaKH]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[selectMaDKByMaKH]
(@maKH	nchar(50))
as
	begin
		select maDK from DKDichVu where MaKH = @maKH
	end
GO
/****** Object:  StoredProcedure [dbo].[selectMonth]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[selectMonth]
(@year int)
as
begin
	SELECT DISTINCT month(NgayDat) Month FROM DatPhong where YEAR(NgayDat) like @year ORDER BY Month DESC
end
GO
/****** Object:  StoredProcedure [dbo].[selectTienCocByMaKH]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE  proc  [dbo].[selectTienCocByMaKH]
(@maKH nchar(50))
as
	begin
		select TienCoc from DatPhong where MaKH =  @maKH
	end
GO
/****** Object:  StoredProcedure [dbo].[selectTienDVByMaKH]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[selectTienDVByMaKH]
(@maKH nchar(50))
as
	begin
		select Gia from DKDichVu where MaKH = @maKH
	end
GO
/****** Object:  StoredProcedure [dbo].[selectYear]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[selectYear] 
as
	begin
		SELECT DISTINCT year(NgayDat) Year FROM DatPhong ORDER BY Year DESC 
	end
GO
/****** Object:  StoredProcedure [dbo].[ThanhTienHD]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[ThanhTienHD]
(@maKH nchar(50))
as
	begin
		select 
				(p.GiaPhong*datediff(day,NgayDat,NgayTra)+dv.Gia)-TienCoc as ThanhTien
						from thanhtoan tt 
				inner join khachhang kh on tt.MaKH=kh.MaKH
				inner join datPhong dp on tt.madp=dp.madp
				inner join Phong p on dp.MaPhong=p.MaPhong
				inner join DKDichVu dv on tt.MaDK=dv.MaDK
		where tt.MaKH = @maKH
	end
GO
/****** Object:  StoredProcedure [dbo].[TK_DoanhThu]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[TK_DoanhThu]
(@selecttype int ,@year int,@month int ,@day int) 
as
	begin
	-- 0 là năm , 1 là  tháng, 2 là ngày
		-- nếu truyền vào là 0 - năm
		if(@selecttype = 0)
			begin
				select 
					count (distinct tt.MaTT) SoHD,
					p.TenPhong TenPhong,
					SUM (tt.ThanhTien) as  DoanhThu,
					Max (tt.ThanhTien) as  HDCaoNhat,
					Min (tt.ThanhTien) as  HDThapNhat,
					AVG (tt.ThanhTien) as  HDTrungBinh
					from ThanhToan tt join DatPhong dp on tt.MaDP=dp.MaDP
								 join Phong p on dp.MaPhong=p.MaPhong	
					where year(dp.NgayDat) = @year
					group by p.TenPhong,year(dp.NgayDat)
			end
		---- nếu truyền vào là 1 - tháng
		if(@selecttype = 1)
			begin
				select 
					count (distinct tt.MaTT) SoHD,
					p.TenPhong TenPhong,
					SUM (tt.ThanhTien) as  DoanhThu,
					Max (tt.ThanhTien) as  HDCaoNhat,
					Min (tt.ThanhTien) as  HDThapNhat,
					AVG (tt.ThanhTien) as  HDTrungBinh
					from ThanhToan tt join DatPhong dp on tt.MaDP=dp.MaDP
								 join Phong p on dp.MaPhong=p.MaPhong	
					where year(dp.NgayDat) = @year and month(dp.NgayDat) = @month
					group by p.TenPhong,year(dp.NgayDat),month(dp.NgayDat)
			end
		-- nếu truyền vào là 2 - ngày
		if(@selecttype = 2)
			begin
				select 
					count (distinct tt.MaTT) SoHD,
					p.TenPhong TenPhong,
					SUM (tt.ThanhTien) as  DoanhThu,
					Max (tt.ThanhTien) as  HDCaoNhat,
					Min (tt.ThanhTien) as  HDThapNhat,
					AVG (tt.ThanhTien) as  HDTrungBinh
					from ThanhToan tt join DatPhong dp on tt.MaDP=dp.MaDP
								 join Phong p on dp.MaPhong=p.MaPhong	
					where year(dp.NgayDat) = @year and month(dp.NgayDat) = @month and day(dp.NgayDat) = @day
					group by p.TenPhong,year(dp.NgayDat),month(dp.NgayDat),day(dp.NgayDat)
			end
	end		
GO
/****** Object:  StoredProcedure [dbo].[TK_TongKetDoanhThu]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[TK_TongKetDoanhThu]
as
	begin
		select
					year(ngayDat) Nam,
					SUM (tt.ThanhTien) as  DoanhThu
					from ThanhToan tt join DatPhong dp on tt.MaDP=dp.MaDP
								 join Phong p on dp.MaPhong=p.MaPhong	
					group by year(dp.NgayDat)
	end
GO
/****** Object:  StoredProcedure [dbo].[Update_dangkydichvu]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[Update_dangkydichvu]
(@MaDK NCHAR(10),@SoLuongDV INT,@MaDV NCHAR(10),@MaKH NCHAR(10),@Gia FLOAT)
as
	begin
		UPDATE DKDichVu SET SLDichVu=@SoLuongDV,MaDV=@MaDV,MaKH=@MaKH,Gia=@Gia WHERE MaDK = @MaDK
	end
GO
/****** Object:  StoredProcedure [dbo].[Update_datphong]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[Update_datphong]
(@NgayDat DATE=null,@NgayTra DATE=null,@TienCoc FLOAT=null,@maDP nchar(50)=null)
as
	begin
		if (@maDP is null or @NgayDat is null or @NgayTra is null or @TienCoc is null)
			begin
				print N'Các trường dữ liệu không được để trống';
				return 0;
			end
		else
			begin
				UPDATE DatPhong SET NgayDat=@NgayDat,NgayTra=@NgayTra,TienCoc=@TienCoc WHERE MaDP = @maDP
				return 1;
			end
	end
GO
/****** Object:  StoredProcedure [dbo].[Update_dichvu]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[Update_dichvu]
(@TenDV NVARCHAR(50)=null,@Gia FLOAT=null,@MaDV nchar(50)=null)
as
	if (@MaDV is null or @TenDV is null or @Gia is null)
			begin
				print N'Các trường dữ liệu không được để trống';
				return 0;
			end
		else
	begin
		UPDATE DichVu SET TenDV=@TenDV,Gia=@Gia WHERE MaDV = @MaDV
		return 1;
	end
GO
/****** Object:  StoredProcedure [dbo].[Update_DoiMK]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[Update_DoiMK]
(@TenTK varchar(50)=null,@MatKhau varchar(50)=null)
as
	begin
		if (@TenTK is null or @MatKhau is null)
			begin
				print N'Các trường dữ liệu không được để trống';
				return 0;
			end
		else
			begin
				UPDATE TaiKhoan SET MatKhau=@MatKhau WHERE TenTK = @TenTK
				return 1;
			end
	end
GO
/****** Object:  StoredProcedure [dbo].[Update_khachhang]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[Update_khachhang]
(@MaKH NCHAR(10)=null,@HoTen NVARCHAR(50)=null,@NgaySinh DATE=null,@GioiTinh BIT=null,@CCCD VARCHAR(12)=null,@DiaChi NVARCHAR(100)=null,@Email VARCHAR(50)=null,@Sdt VARCHAR(12)=null)
as
	begin
		if(@HoTen is null or @NgaySinh is null or @GioiTinh is null or @CCCD is null or @DiaChi is null or @Email is null or @Sdt is null)
			begin
				print N'Các trường dữ liệu không được để trống';
				return 0;
			end
		else
			begin
				UPDATE KhachHang SET HoTen=@HoTen,NgaySinh=@NgaySinh,GioiTinh=@GioiTinh,CCCD=@CCCD,DiaChi=@DiaChi,Email=@Email,Sdt=@Sdt WHERE MaKH =@MaKH
				return 1;
			end
	end
GO
/****** Object:  StoredProcedure [dbo].[Update_NhanVien]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[Update_NhanVien]
(@HoTen nvarchar(50)=null,@NgaySinh date=null,@GioiTinh bit=null,@CCCD varchar(12)=null,@DiaChi nvarchar(100)=null,@Email varchar(50)=null,@SoDienThoai varchar(12)=null,@ChucVu nvarchar(20)=null,@MaNV nchar(10)=null)
as
	begin
		if(@MaNV is null or @HoTen is null or @NgaySinh  is null or @GioiTinh is null or @CCCD  is null or @DiaChi is null or @Email is null or @SoDienThoai is null or @ChucVu is null)
			begin
				print N'Các trường dữ liệu không được để trống';
				return 0;
			end
		else
			begin
				UPDATE NhanVien SET HoTen=@HoTen,NgaySinh=@NgaySinh,GioiTinh=@GioiTinh,CCCD=@CCCD,DiaChi=@DiaChi,Email=@Email,SDT=@SoDienThoai,ChucVu=@ChucVu WHERE MaNV = @MaNV;
				return 1;
			end	
	end
GO
/****** Object:  StoredProcedure [dbo].[Update_PHONG]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[Update_PHONG]
(@TenPhong nvarchar(20)=null,@LoaiPhong nvarchar(20)=null,@GiaPhong float=null,@MaPhong nchar(10)=null)
as
	begin
		if (@TenPhong is null or @LoaiPhong is null or  @GiaPhong is null or  @MaPhong is null)
			begin
				print N'Các trường dữ liệu không được để trống';
				return 0;
			end
		else
			begin
				UPDATE Phong SET TenPhong=@TenPhong,LoaiPhong=@LoaiPhong,GiaPhong=@GiaPhong WHERE MaPhong = @MaPhong
				return 1;
			end
	end
GO
/****** Object:  StoredProcedure [dbo].[Update_TaiKhoan]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[Update_TaiKhoan]
(@MatKhau varchar(50)=null,@ChucVu nvarchar(10)=null,@MaNV nchar(10)=null,@TenTK varchar(50)=null)
as
	begin
		if(@MatKhau is null or @ChucVu is null or @MaNV is null or @TenTK is null)
			begin
				print N'Các trường dữ liệu không được để trống'
				return 0;	
			end
		else
			begin
				UPDATE TaiKhoan SET MatKhau=@MatKhau,ChucVu=@ChucVu,MaNV=@MaNV WHERE TenTK = @TenTK
				return 1;
			end
	end
GO
/****** Object:  StoredProcedure [dbo].[Update_ThanhToan]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[Update_ThanhToan]
(@MaDK nchar(10),@MaDP nchar(10),@MaNV nchar(10),@MaKH nchar(10),@ThanhTien float,@MaTT int)
as
	begin
		UPDATE ThanhToan SET MaDK=@MaDK,MaDP=@MaDP,MaNV=@MaNV,MaKH=@MaKH,ThanhTien=@ThanhTien WHERE MaTT = @MaTT
	end

GO
/****** Object:  StoredProcedure [dbo].[UpdateByPhongDaDat]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[UpdateByPhongDaDat]
@maPhong nchar(20)
as
	begin
		update Phong set TinhTrang = N'Phòng đang thuê' where Phong.MaPhong=@maPhong
	end
GO
/****** Object:  StoredProcedure [dbo].[UpdateByPhongDangThue]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[UpdateByPhongDangThue]
(@maPhong nchar(50))
as
	begin
			update Phong set TinhTrang = N'Phòng trống' where Phong.MaPhong=@maPhong
	end
GO
/****** Object:  Trigger [dbo].[ChangeTTAfterDeletePhong]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create trigger [dbo].[ChangeTTAfterDeletePhong] on [dbo].[DatPhong]
after delete as
begin
	update Phong set TinhTrang=N'Phòng trống' where Phong.MaPhong in (select MaPhong from deleted)
end
GO
ALTER TABLE [dbo].[DatPhong] ENABLE TRIGGER [ChangeTTAfterDeletePhong]
GO
/****** Object:  Trigger [dbo].[ChangeTTAfterInsertPhong]    Script Date: 18/3/2022 1:38:54 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE trigger [dbo].[ChangeTTAfterInsertPhong] on [dbo].[DatPhong]
after insert as
	begin 
			begin
				update Phong set TinhTrang=N'Phòng đã đặt trước' where Phong.MaPhong in (select MaPhong from inserted)
			end
	end
GO
ALTER TABLE [dbo].[DatPhong] ENABLE TRIGGER [ChangeTTAfterInsertPhong]
GO
USE [master]
GO
ALTER DATABASE [GFTHotel] SET  READ_WRITE 
GO
