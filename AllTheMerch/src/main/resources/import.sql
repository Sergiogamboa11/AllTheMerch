INSERT INTO Customer VALUES (1, '1234 Street St', 'user@email.com', 'Peter', 'Peterson', 'password1', 'TX', 'user1', 12345), (2, '1244 Avenue Ave', 'Steven123@email.com', 'Steven', 'Stevenson', 'password2', 'VA', 'Steven123', 54321);

INSERT INTO Artist (artist_id, artist_name, artist_description, artist_image) VALUES (1, 'Between the Buried and Me', 'Between the Buried and Me is an American progressive metal band from Raleigh, North Carolina.', ''), (2, 'TesseracT', 'Tesseract (often stylized as TesseracT) are an English progressive metal band from Milton Keynes, England.', '');

INSERT INTO Item (item_id, artist_id, name, type, stock, description, image, price) VALUES (1, 1, 'Between the Buried and Me - Desert Shirt', 'Shirt', 100, 'White t-shirt. Front only.', 'https://allthemerchbucket.s3-us-west-1.amazonaws.com/BetweenTheBuriedAndMe-shirt01.png', 14.99);
INSERT INTO Item (item_id, artist_id, name, type, stock, description, image, price) VALUES (2, 1, 'Between the Buried and Me - Colors Shirt', 'Shirt', 75, 'Black t-shirt. Printed on Tultex brand garments.', 'https://allthemerchbucket.s3-us-west-1.amazonaws.com/BetweenTheBuriedAndMe-shirt02.png', 19.99);
INSERT INTO Item (item_id, artist_id, name, type, stock, description, image, price) VALUES (3, 1, 'Between the Buried and Me - Illustration Zip-Up', 'Hoodie', 100, 'Printed on Tultex brand zip-ups.', 'https://allthemerchbucket.s3-us-west-1.amazonaws.com/BetweenTheBuriedAndMe-hoodie01.jpg', 39.99);
INSERT INTO Item (item_id, artist_id, name, type, stock, description, image, price) VALUES (4, 1, 'Between the Buried and Me - Automata I Zip-Up', 'Hoodie', 90, 'Printed on Tultex brand zip-ups.', 'https://allthemerchbucket.s3-us-west-1.amazonaws.com/BetweenTheBuriedAndMe-hoodie02.jpg', 39.99);
INSERT INTO Item (item_id, artist_id, name, type, stock, description, image, price) VALUES (5, 1, 'Between the Buried and Me - Automata II Snapback Hat', 'Hat', 35, 'Black snapback hat with embroidered front logo.', 'https://allthemerchbucket.s3-us-west-1.amazonaws.com/BetweenTheBuriedAndMe-snapback01.jpg', 39.99);
INSERT INTO Item (item_id, artist_id, name, type, stock, description, image, price) VALUES (6, 1, 'Between the Buried and Me - Desert Wall Flag', 'Wall Flag', 120, '42" x 60" wall flag with holes in all four corners for easy hanging.', 'https://allthemerchbucket.s3-us-west-1.amazonaws.com/BetweenTheBuriedAndMe-wallflag01.jpg', 39.99);
INSERT INTO Item (item_id, artist_id, name, type, stock, description, image, price) VALUES (7, 1, 'Between the Buried and Me - Coma Ecliptic CD', 'CD', 500, '2015 Metal Blade Records', 'https://allthemerchbucket.s3-us-west-1.amazonaws.com/BetweenTheBuriedAndMe-ComaEcliptic.jpeg', 39.99);

INSERT INTO Cart (cart_id, customer_id) VALUES (1, 1);

INSERT INTO Cart_Item (cart_item_id, cart_id, item_id, quantity) VALUES (1, 1, 1, 1);
