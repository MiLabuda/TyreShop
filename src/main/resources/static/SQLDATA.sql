INSERT INTO t_tyre (tyreId, ean, season, tyreManufacturer, tyreModel, tyreWidth, tyreProfile, tyreRim, loadIndex, speedIndex, dot, quantity, price) VALUES (1, 333, 'WINTER', 'Nokian', 'WR D4', 205, 55, 16, 91, 'V', 2022, 1000, 250.00);

INSERT INTO t_tyre (tyreId, ean, season, tyreManufacturer, tyreModel, tyreWidth, tyreProfile, tyreRim, loadIndex, speedIndex, dot, quantity, price) VALUES
(2, 444, 'SUMMER', 'Michelin', 'Pilot Sport', 215, 55, 17, 95, 'V', 2021, 100, 450.00);

INSERT INTO t_tyre (tyreId, ean, season, tyreManufacturer, tyreModel, tyreWidth, tyreProfile, tyreRim, loadIndex, speedIndex, dot, quantity, price) VALUES
(3, 555, 'ALLSEASON', 'Debica', 'Presto', 195, 65, 15, 88, 'T', 2020, 50, 150.00);

INSERT INTO t_order (orderId, user, tyres, orderDate) VALUES
(1, 1, {1,2,3}, TIMESTAMP '2022-06-06 15:00:00');

INSERT INTO t_user(userId, firstName, lastName, email) VALUES
(1, 'John', 'Smith', 'jsmith515@gmail.com');



