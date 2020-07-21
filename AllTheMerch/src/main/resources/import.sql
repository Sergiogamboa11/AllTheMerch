INSERT INTO Customer VALUES (1, '1234 Street St', 'user@email.com', 'Peter', 'Peterson', 'password1', 'TX', 'user1', 12345), (2, '1244 Avenue Ave', 'Steven123@email.com', 'Steven', 'Stevenson', 'password2', 'VA', 'Steven123', 54321);

INSERT INTO Artist (artist_id, artist_name, artist_description, artist_image) VALUES (1, 'Between the Buried and Me', 'Between the Buried and Me is an American progressive metal band from Raleigh, North Carolina.', ''), (2, 'TesseracT', 'Tesseract (often stylized as TesseracT) are an English progressive metal band from Milton Keynes, England.', '');

INSERT INTO Item (item_id, artist_id, name, type, stock, description, image, price) VALUES (1, 1, 'Between the Buried and Me - Desert Shirt', 'Shirt', 100, 'Shirt Description 1', 'https://allthemerchbucket.s3-us-west-1.amazonaws.com/BetweenTheBuriedAndMe-shirt01.png', 14.99), (2, 1, 'Between the Buried and Me - Colors Shirt', 'Shirt', 75, 'Shirt Description 2', 'https://allthemerchbucket.s3-us-west-1.amazonaws.com/BetweenTheBuriedAndMe-shirt02.png', 19.99);

INSERT INTO Cart (cart_id, customer_id) VALUES (1, 1);

INSERT INTO Cart_Item (cart_item_id, cart_id, item_id, quantity) VALUES (1, 1, 1, 1);
