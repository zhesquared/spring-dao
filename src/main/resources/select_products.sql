SELECT product_name 
	FROM netology.orders
	JOIN netology.customers ON orders.customer_id = customers.id
	WHERE customers.name = :name