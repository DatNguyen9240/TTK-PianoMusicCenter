USE [TTKPianoMusicCenter]
GO
/****** Object:  Table [dbo].[Categories]    Script Date: 7/7/2024 5:23:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categories](
	[cid] [int] NOT NULL,
	[cname] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[cid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[courses]    Script Date: 7/7/2024 5:23:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[courses](
	[courseID] [int] IDENTITY(1,1) NOT NULL,
	[image] [varchar](255) NULL,
	[description] [text] NULL,
	[price] [decimal](10, 2) NULL,
	[startDate] [date] NULL,
	[endDate] [date] NULL,
	[cid] [int] NULL,
	[name] [varchar](100) NULL,
	[sell_id] [int] NULL,
	[quantity] [int] NULL,
	[status] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[courseID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Registration]    Script Date: 7/7/2024 5:23:44 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Registration](
	[username] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NULL,
	[fullname] [nvarchar](50) NULL,
	[isAdmin] [bit] NULL,
	[sell_id] [int] IDENTITY(1,1) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[sell_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Categories] ([cid], [cname]) VALUES (1, N'Basic')
INSERT [dbo].[Categories] ([cid], [cname]) VALUES (2, N'Advanced')
GO
SET IDENTITY_INSERT [dbo].[courses] ON 

INSERT [dbo].[courses] ([courseID], [image], [description], [price], [startDate], [endDate], [cid], [name], [sell_id], [quantity], [status]) VALUES (9, N'https://img.upanh.tv/2024/07/02/jordan-whitfield-BhfE1IgcsA8-unsplash.md.jpg', N'These courses can vary widely in terms of content, approach, and target audience.', CAST(123.22 AS Decimal(10, 2)), CAST(N'2024-12-05' AS Date), CAST(N'2024-12-21' AS Date), 1, N'Read the music sheet', 1, 20, 0)
INSERT [dbo].[courses] ([courseID], [image], [description], [price], [startDate], [endDate], [cid], [name], [sell_id], [quantity], [status]) VALUES (10, N'https://img.upanh.tv/2024/07/02/piano-7460435_1280.md.jpg', N'These courses can vary widely in terms of content, approach, and target audience.', CAST(222.22 AS Decimal(10, 2)), CAST(N'2024-12-12' AS Date), CAST(N'2024-12-21' AS Date), 2, N'Chords', 2, 10, 0)
INSERT [dbo].[courses] ([courseID], [image], [description], [price], [startDate], [endDate], [cid], [name], [sell_id], [quantity], [status]) VALUES (11, N'https://i.ibb.co/KDm4QX6/piano-7890735-1280.jpg', N'These courses can vary widely in terms of content, approach, and target audience.', CAST(111.22 AS Decimal(10, 2)), CAST(N'2025-01-12' AS Date), CAST(N'2025-02-21' AS Date), 1, N'Rhythm', 3, 10, 0)
INSERT [dbo].[courses] ([courseID], [image], [description], [price], [startDate], [endDate], [cid], [name], [sell_id], [quantity], [status]) VALUES (12, N'https://i.ibb.co/WsXgfVY/music-sheet-5117328-1280.jpg', N'These courses can vary widely in terms of content, approach, and target audience.', CAST(855.22 AS Decimal(10, 2)), CAST(N'2025-01-12' AS Date), CAST(N'2025-02-21' AS Date), 1, N'sheet music', 3, 0, 0)
INSERT [dbo].[courses] ([courseID], [image], [description], [price], [startDate], [endDate], [cid], [name], [sell_id], [quantity], [status]) VALUES (13, N'https://img.upanh.tv/2024/07/02/jordan-whitfield-BhfE1IgcsA8-unsplash.md.jpg', N'These courses can vary widely in terms of content, approach, and target audience.', CAST(662.22 AS Decimal(10, 2)), CAST(N'2025-02-12' AS Date), CAST(N'2025-06-21' AS Date), 1, N'chords music', 4, 10, 0)
INSERT [dbo].[courses] ([courseID], [image], [description], [price], [startDate], [endDate], [cid], [name], [sell_id], [quantity], [status]) VALUES (14, N'https://i.ibb.co/ZS673rC/piano-4798138-1280.jpg', N'These courses can vary widely in terms of content, approach, and target audience.', CAST(999.22 AS Decimal(10, 2)), CAST(N'2025-02-12' AS Date), CAST(N'2025-06-21' AS Date), 2, N'bosanova', 5, 20, 0)
INSERT [dbo].[courses] ([courseID], [image], [description], [price], [startDate], [endDate], [cid], [name], [sell_id], [quantity], [status]) VALUES (15, N'https://i.ibb.co/WsXgfVY/music-sheet-5117328-1280.jpg', N'These courses can vary widely in terms of content, approach, and target audience.', CAST(123.55 AS Decimal(10, 2)), CAST(N'2025-01-12' AS Date), CAST(N'2025-02-12' AS Date), 1, N'Passing chords', 5, 20, 1)
INSERT [dbo].[courses] ([courseID], [image], [description], [price], [startDate], [endDate], [cid], [name], [sell_id], [quantity], [status]) VALUES (16, N'https://i.ibb.co/ZS673rC/piano-4798138-1280.jpg', N'These courses can vary widely in terms of content, approach, and target audience.', CAST(999.22 AS Decimal(10, 2)), CAST(N'2025-02-12' AS Date), CAST(N'2025-06-21' AS Date), 2, N'Half Beat Bounce', 5, 20, 0)
INSERT [dbo].[courses] ([courseID], [image], [description], [price], [startDate], [endDate], [cid], [name], [sell_id], [quantity], [status]) VALUES (17, N'https://img.upanh.tv/2024/07/02/jordan-whitfield-BhfE1IgcsA8-unsplash.md.jpg', N'These courses can vary widely in terms of content, approach, and target audience.', CAST(999.22 AS Decimal(10, 2)), CAST(N'2025-02-12' AS Date), CAST(N'2025-06-21' AS Date), 1, N'Pop', 4, 10, 0)
INSERT [dbo].[courses] ([courseID], [image], [description], [price], [startDate], [endDate], [cid], [name], [sell_id], [quantity], [status]) VALUES (18, N'https://i.ibb.co/xggmjFV/keyboard-7312016-1280.jpg', N'These courses can vary widely in terms of content, approach, and target audience.', CAST(999.22 AS Decimal(10, 2)), CAST(N'2025-02-12' AS Date), CAST(N'2025-06-21' AS Date), 1, N'Blues', 2, 0, 0)
INSERT [dbo].[courses] ([courseID], [image], [description], [price], [startDate], [endDate], [cid], [name], [sell_id], [quantity], [status]) VALUES (19, N'https://i.ibb.co/WsXgfVY/music-sheet-5117328-1280.jpg', N'These courses can vary widely in terms of content, approach, and target audience.', CAST(212.22 AS Decimal(10, 2)), CAST(N'2025-03-12' AS Date), CAST(N'2025-04-21' AS Date), 2, N'Jazz', 3, 0, 0)
INSERT [dbo].[courses] ([courseID], [image], [description], [price], [startDate], [endDate], [cid], [name], [sell_id], [quantity], [status]) VALUES (20, N'https://i.ibb.co/ZS673rC/piano-4798138-1280.jpg', N'These courses can vary widely in terms of content, approach, and target audience.', CAST(212.22 AS Decimal(10, 2)), CAST(N'2025-03-12' AS Date), CAST(N'2025-04-21' AS Date), 2, N'Ballads', 1, 20, 0)
INSERT [dbo].[courses] ([courseID], [image], [description], [price], [startDate], [endDate], [cid], [name], [sell_id], [quantity], [status]) VALUES (21, N'https://i.ibb.co/ZS673rC/piano-4798138-1280.jpg', N'These courses can vary widely in terms of content, approach, and target audience.', CAST(555.22 AS Decimal(10, 2)), CAST(N'2025-03-12' AS Date), CAST(N'2025-04-21' AS Date), 1, N'Improvisation', 4, 0, 1)
INSERT [dbo].[courses] ([courseID], [image], [description], [price], [startDate], [endDate], [cid], [name], [sell_id], [quantity], [status]) VALUES (22, N'https://i.ibb.co/ncJRKch/piano-775509-1280.jpg', N'These courses can vary widely in terms of content, approach, and target audience.', CAST(99.22 AS Decimal(10, 2)), CAST(N'2025-02-12' AS Date), CAST(N'2025-06-21' AS Date), 2, N'Beginer', 1, 10, 1)
INSERT [dbo].[courses] ([courseID], [image], [description], [price], [startDate], [endDate], [cid], [name], [sell_id], [quantity], [status]) VALUES (23, N'https://media.istockphoto.com/id/1088835538/vi/anh/h%C3%ACnh-%E1%BA%A3nh-c%E1%BA%ADn-c%E1%BA%A3nh-b%C3%A0n-tay-ch%C6%A1i-piano.jpg?s=1024x1024&w=is&k=20&c=X5uAvcfxu-QOEoPpZpcUqJFOJe0ygcawbD7FVWTRpFk=', N'These courses can vary widely in terms of content, approach, and target audience.', CAST(423.22 AS Decimal(10, 2)), CAST(N'2025-02-12' AS Date), CAST(N'2025-06-21' AS Date), 1, N'iStock', 2, 10, 1)
INSERT [dbo].[courses] ([courseID], [image], [description], [price], [startDate], [endDate], [cid], [name], [sell_id], [quantity], [status]) VALUES (24, N'https://i.ibb.co/ZS673rC/piano-4798138-1280.jpg', N'These courses can vary widely in terms of content, approach, and target audience.', CAST(666.22 AS Decimal(10, 2)), CAST(N'2025-01-12' AS Date), CAST(N'2025-07-21' AS Date), 1, N'KICM', 2, 20, 1)
INSERT [dbo].[courses] ([courseID], [image], [description], [price], [startDate], [endDate], [cid], [name], [sell_id], [quantity], [status]) VALUES (25, N'https://i.ibb.co/WHdfJrx/piano-2592963-1280.jpg', N'These courses can vary widely in terms of content, approach, and target audience.', CAST(666.22 AS Decimal(10, 2)), CAST(N'2025-01-12' AS Date), CAST(N'2025-07-21' AS Date), 1, N'TJIS', 1, 10, 1)
INSERT [dbo].[courses] ([courseID], [image], [description], [price], [startDate], [endDate], [cid], [name], [sell_id], [quantity], [status]) VALUES (27, N'https://i.ibb.co/WsXgfVY/music-sheet-5117328-1280.jpg', N'These courses can vary widely in terms of content, approach, and target audience.', CAST(387.22 AS Decimal(10, 2)), CAST(N'2025-02-12' AS Date), CAST(N'2025-08-21' AS Date), 1, N'LIOE', 3, 0, 1)
INSERT [dbo].[courses] ([courseID], [image], [description], [price], [startDate], [endDate], [cid], [name], [sell_id], [quantity], [status]) VALUES (28, N'https://i.ibb.co/ncJRKch/piano-775509-1280.jpg', N'These courses can vary widely in terms of content, approach, and target audience.', CAST(123.22 AS Decimal(10, 2)), CAST(N'2025-02-12' AS Date), CAST(N'2025-04-11' AS Date), 2, N'YUEJ', 3, 0, 1)
INSERT [dbo].[courses] ([courseID], [image], [description], [price], [startDate], [endDate], [cid], [name], [sell_id], [quantity], [status]) VALUES (29, N'https://i.ibb.co/xggmjFV/keyboard-7312016-1280.jpg', N'These courses can vary widely in terms of content, approach, and target audience.', CAST(123.22 AS Decimal(10, 2)), CAST(N'2025-01-12' AS Date), CAST(N'2025-03-11' AS Date), 1, N'TRENL', 5, 20, 1)
INSERT [dbo].[courses] ([courseID], [image], [description], [price], [startDate], [endDate], [cid], [name], [sell_id], [quantity], [status]) VALUES (30, N'https://i.ibb.co/WHdfJrx/piano-2592963-1280.jpg', N'These courses can vary widely in terms of content, approach, and target audience.', CAST(123.22 AS Decimal(10, 2)), CAST(N'2025-01-12' AS Date), CAST(N'2025-02-19' AS Date), 2, N'MAJU', 5, 10, 1)
INSERT [dbo].[courses] ([courseID], [image], [description], [price], [startDate], [endDate], [cid], [name], [sell_id], [quantity], [status]) VALUES (31, N'https://i.ibb.co/WHdfJrx/piano-2592963-1280.jpg', N'These courses can vary widely in terms of content, approach, and target audience.', CAST(123.22 AS Decimal(10, 2)), CAST(N'2025-01-12' AS Date), CAST(N'2025-02-19' AS Date), 2, N'WUY', 2, 10, 1)
INSERT [dbo].[courses] ([courseID], [image], [description], [price], [startDate], [endDate], [cid], [name], [sell_id], [quantity], [status]) VALUES (32, N'https://i.ibb.co/WHdfJrx/piano-2592963-1280.jpg', N'These courses can vary widely in terms of content, approach, and target audience.', CAST(123.22 AS Decimal(10, 2)), CAST(N'2025-01-12' AS Date), CAST(N'2025-02-19' AS Date), 1, N'LIUE', 4, 10, 1)
INSERT [dbo].[courses] ([courseID], [image], [description], [price], [startDate], [endDate], [cid], [name], [sell_id], [quantity], [status]) VALUES (33, N'https://media.istockphoto.com/id/1286861789/vi/anh/tay-ph%E1%BB%A5-n%E1%BB%AF-ch%C6%A1i-piano.jpg?s=1024x1024&w=is&k=20&c=OlXaRCnb3mkmUk1LW1_wWwB7-8rBa2QrngFEUSnHkzA=', N'These courses can vary widely in terms of content, approach, and target audience.', CAST(748.22 AS Decimal(10, 2)), CAST(N'2025-01-12' AS Date), CAST(N'2025-02-19' AS Date), 2, N'JAFAN', 3, 0, 1)
INSERT [dbo].[courses] ([courseID], [image], [description], [price], [startDate], [endDate], [cid], [name], [sell_id], [quantity], [status]) VALUES (34, N'https://i.ibb.co/WHdfJrx/piano-2592963-1280.jpg', N'when you relate and you want to chill', CAST(212.32 AS Decimal(10, 2)), CAST(N'2024-09-12' AS Date), CAST(N'2024-10-01' AS Date), 1, N'Piano Chill', 4, 10, 1)
SET IDENTITY_INSERT [dbo].[courses] OFF
GO
SET IDENTITY_INSERT [dbo].[Registration] ON 

INSERT [dbo].[Registration] ([username], [password], [fullname], [isAdmin], [sell_id]) VALUES (N'abc111', N'123456', N'Nguyen Van Duy Khiem', 0, 1)
INSERT [dbo].[Registration] ([username], [password], [fullname], [isAdmin], [sell_id]) VALUES (N'se180166', N'japan', N'Tran Manh Phu', 1, 2)
INSERT [dbo].[Registration] ([username], [password], [fullname], [isAdmin], [sell_id]) VALUES (N'se180194', N'frontend', N'Tran Minh Khoa', 0, 3)
INSERT [dbo].[Registration] ([username], [password], [fullname], [isAdmin], [sell_id]) VALUES (N'se180197', N'02468', N'Nguyen Thanh Dat', 1, 4)
INSERT [dbo].[Registration] ([username], [password], [fullname], [isAdmin], [sell_id]) VALUES (N'se180199', N'13579', N'Bui Chuong Quoc Tuong', 0, 5)
INSERT [dbo].[Registration] ([username], [password], [fullname], [isAdmin], [sell_id]) VALUES (N'se210522', N'21051234', N'tran vu', 0, 6)
SET IDENTITY_INSERT [dbo].[Registration] OFF
GO
ALTER TABLE [dbo].[courses]  WITH CHECK ADD FOREIGN KEY([cid])
REFERENCES [dbo].[Categories] ([cid])
GO
ALTER TABLE [dbo].[courses]  WITH CHECK ADD FOREIGN KEY([sell_id])
REFERENCES [dbo].[Registration] ([sell_id])
GO
