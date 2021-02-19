insert into user(user_name,user_password,real_name,address,tel,mail,profile,point) values('1','1','ユーザー1','住所1','番号1','メール1',null,0);
insert into user(user_name,user_password,real_name,address,tel,mail,profile,point) values('2','2','ユーザー2','住所2','番号2','メール2',null,0);
insert into user(user_name,user_password,real_name,address,tel,mail,profile,point) values('3','3','ユーザー3','住所3','番号3','メール3',null,0);

commit;

			select deal.deal_id,deal.before_payment_id,deal.after_payment_id,deal.item_id,item.item_name,item.item_image,item.seller_id,item.term,deal.deal_state,deal.time_limit,deal.user_id,deal.user_state 
					from deal inner join item on deal.item_id = item.item_id
					 where item.seller_id = 1;