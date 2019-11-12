CREATE TABLE myspring.student (
	 id varchar(255),
     passwd varchar(255),
     username varchar(255),
     snum varchar(255),
     depart varchar(255),
     mobile varchar(255),
     email varchar(255),
     PRIMARY KEY(id)
);

# 게시글 테이블 생성
CREATE TABLE myspring.board (
	 boardIdx int not null auto_increment,
     boardTitle varchar(255) not null,
     boardContent text not null,
     writer varchar(255) not null,
     writeDate datetime not null default now(),
     modifier varchar(255),
     modifyDate datetime,
     important int not null default 0,
     enabled int not null default 1,
     boardViewCnt int not null default 0,
     boardReplyCnt int not null default 0,
     boardFilePath varchar(255),
     PRIMARY KEY(boardIdx)
);

# 댓글 테이블 생성(2019.10.31 수정(group, depth 삭제))
CREATE TABLE myspring.reply (
	replyIdx int auto_increment not null primary key,
    boardIdx int not null,
    replyParent int not null default 0,
    replyContent text not null,
    replyWriter varchar(255) not null,
    replyWriteDate datetime not null default now(),
    replyModifier varchar(255),
    replyModifyDate datetime not null default now(),
    enabled int not null default 1,
    constraint reply_board_fk
    foreign key (boardIdx) references myspring.board (boardIdx)
);

# 장바구니 테이블 생성
CREATE TABLE myspring.cart (
	cartIdx int not null auto_increment primary key,
    writer varchar(255) not null,
    goodsIdx int not null,
    goodsAmount int not null,
    constraint cart_goods_fk
    foreign key (goodsIdx) references myspring.goods (goodsIdx)
);
# 상품 테이블 생성
CREATE TABLE myspring.goods (
	 goodsIdx int not null auto_increment,
     goodsTitle varchar(255) not null,
     goodsContent text not null,
     writer varchar(255) not null,
     writeDate datetime not null default now(),
     modifier varchar(255),
     modifyDate datetime,
     important int not null default 0,
     enabled int not null default 1,
     goodsViewCnt int not null default 0,
     goodsReviewCnt int not null default 0,
     goodsFilePath varchar(255),
     PRIMARY KEY(goodsIdx)
);

ALTER TABLE myspring.reply DROP `replyGroup`;
ALTER TABLE myspring.reply DROP `replyDepth`;
   
# 게시글 조회수 컬럼 추가
ALTER TABLE myspring.board 
ADD column boardViewCnt int not null default 0;

# 게시글 댓글 개수 컬럼 추가
ALTER TABLE myspring.board 
ADD column boardReplyCnt int not null default 0;

# 게시글 파일경로 컬럼 추가
ALTER TABLE myspring.board 
ADD column boardFilePath varchar(255);

# 전체 게시글 개수 조회
SELECT * FROM myspring.board LIMIT 5, 10;

insert into myspring.reply(boardIdx, replyContent, replyWriter) values ( 2, '댓글1', 'admin');
insert into myspring.reply(boardIdx, replyContent, replyWriter) values ( 2, '댓글2', 'admin');
insert into myspring.reply(boardIdx, replyContent, replyWriter) values ( 2, '댓글3', 'admin');

insert into myspring.reply(boardIdx, replyParent, replyContent, replyWriter, replyWriteDate) values ( 2, 7, '댓글1_1', 'admin', now() );
insert into myspring.reply(boardIdx, replyParent, replyContent, replyWriter, replyWriteDate) values ( 2, 7, '댓글1_2', 'admin', now() );
insert into myspring.reply(boardIdx, replyParent, replyContent, replyWriter, replyWriteDate) values ( 2, 11, '댓글1_2_1', 'admin', now() );

insert into myspring.reply(boardIdx, replyParent, replyContent, replyWriter, replyWriteDate) values ( 2, 8, '댓글2_1', 'admin', now() );
insert into myspring.reply(boardIdx, replyParent, replyContent, replyWriter, replyWriteDate) values ( 2, 8, '댓글2_2', 'admin', now() );

insert into myspring.reply(boardIdx, replyParent, replyContent, replyWriter, replyWriteDate) values ( 2, 9, '댓글3_1', 'admin', now() );

# 대댓글 계층형 테스트
SELECT *
FROM
(SELECT CASE WHEN LEVEL-1 > 0 then CONCAT(CONCAT(REPEAT('    ', level - 1),'┗'), rep.replyContent)
			ELSE rep.replyContent
			END AS replyContent
     , rep.replyIdx
     , rep.replyParent
     , rep.replyWriter
     , rep.boardIdx
     , rep.enabled
     , fnc.level
FROM
	(SELECT fnc_reply_hierarchi() AS replyIdx, @level AS level
	 FROM (SELECT @start_with:=0, @replyIdx:=@start_with, @level:=0) vars
			JOIN myspring.reply
			WHERE @replyIdx IS NOT NULL) fnc
JOIN myspring.reply rep ON fnc.replyIdx = rep.replyIdx) hie
WHERE hie.boardIdx = 3;
