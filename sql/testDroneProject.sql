create table DRONE_PROJECT_INFO(
    drone_project_id serial PRIMARY KEY,
    drone_id int,
    drone_project_name varchar(256),
    drone_project_type varchar(1) default '0',
	shooting_area varchar(100),
	shooting_upper_left_latitude numeric(20,10),
	shooting_upper_left_longitude numeric(20,10),
	shooting_upper_right_latitude numeric(20,10),
	shooting_upper_right_longitude numeric(20,10),
	shooting_lower_right_latitude numeric(20,10),
	shooting_lower_right_longitude numeric(20,10),
	shooting_lower_left_latitude numeric(20,10),
	shooting_lower_left_longitude numeric(20,10),
	location GEOGRAPHY(POINT, 4326),
	shooting_date timestamp with time zone,
	status char(1) default	'0',
	description varchar(256),
	ortho_image_count int default 0,
	postprocessing_image_count  int default 0,
	detected_object_item1_count  int default 0,
	detected_object_item2_count  int default 0,
	detected_object_item3_count  int default 0,
	detected_object_item4_count	 int default 0,
	update_date timestamp,
	insert_date timestamp default now()
);

-- constraint drone_project_pk primary key (drone_project_id)
-- 그리고 gaia3d role유저가 다루는 테이블에서 postgis extension을 사용하기위해서
-- gaia3d를 superuser로 변경
-- postgres# ALTER ROLE gaia3d SUPERUSER;