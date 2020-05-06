ALTER TABLE customer ADD COLUMN password VARCHAR(MAX) NOT NULL DEFAULT 'TMP';

UPDATE customer SET password = 'pass1__app_key' WHERE email = 'janis1.berzins@gmail.com';
UPDATE customer SET password = 'pass2__app_key' WHERE email = 'juris.eziitis@gmail.com';
UPDATE customer SET password = 'pass3__app_key' WHERE email = 'l.sirds@gmail.com';
UPDATE customer SET password = 'pass4__app_key' WHERE email = 'dana.liepa.berzins@gmail.com';
UPDATE customer SET password = 'pass5__app_key' WHERE email = 'toms.ak@gmail.com';
