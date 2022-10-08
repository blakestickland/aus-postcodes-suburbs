SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

DROP TABLE IF EXISTS postcodes_geo;
CREATE TABLE postcodes_geo (
  id int(11) NOT NULL auto_increment,
  postcode varchar(5) collate utf8_unicode_ci default NULL,
  suburb varchar(100) collate utf8_unicode_ci default NULL,
  state varchar(4) collate utf8_unicode_ci default NULL,
  latitude decimal(6,3) default NULL,
  longitude decimal(6,3) default NULL,
  PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;