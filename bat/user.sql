insert into user(user_name,user_password,real_name,address,tel,mail,profile,point) values('0yen','pass','–îì','“Œ‹“s','08032873289','yahagi@gmail.com',null,50000);
insert into user(user_name,user_password,real_name,address,tel,mail,profile,point) values('‚³‚­','pass','ŸNˆä','é‹ÊŒ§','09076541230','sakurai@gmail.com',null,50000);
insert into user(user_name,user_password,real_name,address,tel,mail,profile,point) values('‚È‚é','pass','–kğ','ç—tŒ§','08012341234','hojo0gmail.com',null,50000);

commit;

			select deal.deal_id,deal.before_payment_id,deal.after_payment_id,deal.item_id,item.item_name,item.item_image,item.seller_id,item.term,deal.deal_state,deal.time_limit,deal.user_id,deal.user_state 
					from deal inner join item on deal.item_id = item.item_id
					 where item.seller_id = 1;