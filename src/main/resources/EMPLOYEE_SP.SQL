CREATE OR REPLACE PROCEDURE EMPLOYEE_SP (IN emp_id BIGINT,
                                        OUT emp_cursor REFCURSOR)
LANGUAGE plpgsql
AS $$
BEGIN
    -- Open the cursor for the query
    OPEN emp_cursor FOR
    SELECT *
    FROM Employee
    WHERE id = emp_id;
END;
$$;

