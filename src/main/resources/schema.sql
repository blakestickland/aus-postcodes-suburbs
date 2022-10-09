SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';
DROP TABLE IF EXISTS postcodes_geo;

CREATE TABLE postcodes_geo (
  id int(11) NOT NULL auto_increment,
  postcode varchar(5) collate utf8_unicode_ci NOT NULL,
  suburb varchar(100) collate utf8_unicode_ci NOT NULL,
  state varchar(4) collate utf8_unicode_ci default NULL,
  latitude float(6,3) default NULL,
  longitude float(6,3) default NULL,
  PRIMARY KEY  (id),
  UNIQUE KEY unique_location_transaction (postcode, suburb, state)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;