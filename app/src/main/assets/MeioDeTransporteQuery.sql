SELECT
M.ID AS ID
,M.DESCRICAO AS DESCRICAO
,M.TIPO AS TIPO
,E.MEDIA AS MEDIA
,E.MAXIMO AS MAXIMO
,E.MINIMO AS MINIMO
FROM MEIODETRANSPORTE M INNER JOIN ESTATISTICASMEIOTRANSPORTE E
    ON M.ID = E.MEIODETRANSPORTE_ID
    WHERE M.ID =