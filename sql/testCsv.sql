create table ATMOSPHERE(
    atmosphere_id serial PRIMARY KEY,
    measure_time timestamp,
    altitude numeric(20,10),
    lat numeric(20,10),
    lon numeric(20,10),
    temperature numeric(20,10),
    humidity numeric(20,10),
    pressure numeric(20,10),
    vocs numeric(20,10),
    so2 numeric(20,10),
    co numeric(20,10),
    no2 numeric(20,10),
    o3_no2 numeric(20,10),
    pm1 int,
    pm25 int, 
    pm10 int,
    cxhy numeric(20,10),
    h2s numeric(20,10),
    hcl numeric(20,10),
    wr_so2 numeric(20,10),
    tsp numeric(20,10),
    nh3 numeric(20,10),
    co2 numeric(20,10),
    hcn numeric(20,10),
    h2 numeric(20,10),
    ph3 numeric(20,10),
    cl2 numeric(20,10)
);