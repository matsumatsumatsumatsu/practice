insert into humie.user(user_name,user_password,real_name,address,tel,mail,profile,point) values('0yen','pass','矢作','東京都','08032873289','yahagi@gmail.com',null,50000);
insert into humie.user(user_name,user_password,real_name,address,tel,mail,profile,point) values('さく','pass','櫻井','埼玉県','09076541230','sakurai@gmail.com',null,50000);
insert into humie.user(user_name,user_password,real_name,address,tel,mail,profile,point) values('なる','pass','北条','千葉県','08012341234','hojo0gmail.com',null,50000);

commit;

			select deal.deal_id,deal.before_payment_id,deal.after_payment_id,deal.item_id,item.item_name,item.item_image,item.seller_id,item.term,deal.deal_state,deal.time_limit,deal.user_id,deal.user_state 
					from deal inner join item on deal.item_id = item.item_id
					 where item.seller_id = 1;