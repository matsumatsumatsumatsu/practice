insert into user(user_name,user_password,real_name,address,tel,mail,profile,point) values('1','1','���[�U�[1','�Z��1','�ԍ�1','���[��1',null,0);
insert into user(user_name,user_password,real_name,address,tel,mail,profile,point) values('2','2','���[�U�[2','�Z��2','�ԍ�2','���[��2',null,0);
insert into user(user_name,user_password,real_name,address,tel,mail,profile,point) values('3','3','���[�U�[3','�Z��3','�ԍ�3','���[��3',null,0);

commit;

			select deal.deal_id,deal.before_payment_id,deal.after_payment_id,deal.item_id,item.item_name,item.item_image,item.seller_id,item.term,deal.deal_state,deal.time_limit,deal.user_id,deal.user_state 
					from deal inner join item on deal.item_id = item.item_id
					 where item.seller_id = 1;