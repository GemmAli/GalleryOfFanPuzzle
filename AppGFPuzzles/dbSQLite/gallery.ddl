CREATE TABLE 'autores'(
'id_autor' varchar(6)PRIMARY KEY NOT NULL,
'ape_nom' varchar(30),
'fecha_nac' date,
'nacionalidad' varchar(20), 
'telefono' int(9),
'e_mail' varchar(30),
'biografia' text, 
'destreza' varchar(30)
);


CREATE TABLE 'clientes'(
'id_cliente' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, 
'ape_nom_cli' varchar(30),
'dni_cli' varchar(9), 
'e_mail_cli' varchar(30),
'password_cli' varchar(16)
);


CREATE TABLE 'empleados'(
'id_empleado' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
'ape_nom_emple' varchar(30) NOT NULL,
'num_ssocIal' int(10) NOT NULL,
'cuentaBancaria' varchar(20)  NOT NULL,
'dni' varchar(9) NOT NULL,
'e_mail_emple' varchar(30),
'password_emple' varchar(16)
);


CREATE TABLE 'galerias'(
'cif' varchar(9) PRIMARY KEY NOT NULL,
'nombre_gale' varchar(50) NOT NULL,
'direccion_gale' varchar(50)NOT NULL,  
'telefono_gale' int(9) NOT NULL
);


CREATE TABLE 'obras'( 
'id_obra' PRIMARY KEY NOT NULL,  
'titulo' varchar(20) NOT NULL,
'imagen' blob,
'tipo' varchar(10)NOT NULL,
'tamanio' varchar(10)NOT NULL,
'material' varchar(20)NOT NULL,
'descripcion' mediumtext,
'precio' int(11) NOT NULL,
'id_autor' varchar(6), 
FOREIGN KEY(id_autor) REFERENCES autores(id_autor));


CREATE TABLE 'ventas'(
'num_albaran' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,  
'id_obra' varchar(6) NOT NULL,
'id_cliente' varchar(6) NOT NULL,
'id_empleado' varchar(6) NOT NULL,
'fecha' date NOT NULL,
'cif' varchar(9) NOT NULL, 
'precio' int(11) NOT NULL, 
FOREIGN KEY(id_obra) REFERENCES obras(id_obra), 
FOREIGN KEY(id_cliente) REFERENCES clientes(id_cliente),
FOREIGN KEY(id_empleado) REFERENCES empleados(id_empleado),
FOREIGN KEY(cif) REFERENCES galerias(cif),
FOREIGN KEY(precio) REFERENCES obras(precio));


INSERT INTO 'empleados' ('ape_nom_emple', 'num_ssocIal','cuentaBancaria', 'dni', 'e_mail_emple', 'password_emple')
VALUES('Usuario Administrador', '1234567890', 'ES001234123412341234','12345678A', 'admin', 'admin');

INSERT INTO 'autores' ('id_autor', 'ape_nom', 'fecha_nac', 'nacionalidad', 'telefono', 'e_mail', 'biografia', 'destreza') 
VALUES('AUT001', 'Ai Wei Wei', '1957-08-28', 'China', 695325874, 'weiweiweiwei@gmail.com', 'Primeros años de vida y de trabajo:
Su padre fue el poeta chino Ai Qing , que fue denunciado durante el Movimiento Anti-Derecha. 
En 1958, la familia fue enviada a un campo de trabajo forzado en Beidahuang. 
Fueron exiliados a Shihezi , donde vivieron hasta 1976 cuando la familia regresó a Beijing.
1978, Ai se inscribió en la Academia de Cine de Beijing y estudió animación, fue uno de los
fundadores del grupo de arte de vanguardia Las estrellas, junto con Ma Desheng, Wang Keping, 
Mao Lizi etc.
En 1981 a 1993, vivió en los Estados Unidos. Estudió inglés en la Universidad de Pennsylvania 
y en la Universidad de California en Berkeley. 
En 1983 hasta 1986 Se mudó a la ciudad de Nueva York. Estudió en Parsons School of Design y 
Art Students League de Nueva York donde estudió con Bruce Dorfman, Knox Martin y Richard 
Pousette-Dart. Abandonó la escuela y se ganaba la vida dibujando retratos en las calles y 
realizando trabajos ocasionales. Durante este período, se expuso a las obras de Marcel 
Duchamp , Andy Warhol y Jasper Johns , y comenzó a crear arte conceptual al alterar los 
objetos confeccionados. 
Desde de 1983 a 1993, cuando vivía en el East Village, Ai llevaba una cámara con él todo el
tiempo y tomaba fotos de sus alrededores dondequiera que estuviera. La colección de fotos 
resultante  se seleccionó más tarde y ahora se conoce como las Fotografías de Nueva York. 
Volviendo de los Estados Unidos a China 1993, Ai regresó a China Coeditó una serie de tres 
libros sobre esta nueva generación de artistas con el curador chino Feng Boyi: Black Cover 
Book (1994), White Cover Book (1995) y Gray Libro de tapa (1997). 1999, Ai se mudó a 
Caochangdi, en el noreste de Beijing, y construyó una casa de estudio, su primer proyecto 
arquitectónico. Debido a su interés en la arquitectura, fundó el estudio de arquitectura 
FAKE Design, en 2003.2000, co-curó la exposición de arte Fuck Off con el curador Feng 
Boyi en Shanghai, China.', 'Escultura, Pintura, Fotografia');

INSERT INTO 'autores' ('id_autor', 'ape_nom', 'fecha_nac', 'nacionalidad', 'telefono', 'e_mail', 'biografia', 'destreza') 
VALUES('AUT002', 'Jeffrey Koons', '1955-01-21', 'Estados Unidos', 635854785, 'jaffreyKoons@gmail.com', 
'La mayoría de sus obras van al corriente del arte conceptual, minimalista y pop. Aunque 
muchos críticos lo han denominado como el principal artista kitsch. Clasificada a veces como
minimalista y neo-pop, su obra consistía inicialmente en escultura conceptual que fue 
adquiriendo monumentalidad. A la fecha, Koons ha incursionado en la escultura de instalación, 
la pintura, y la fotografía. Jeff Koons está entre los artistas vivientes más cotizados de los 
Estados Unidos. 
Trabajó como corredor de bolsa en Wall Street antes de establecerse como artista. Comenzó a 
hacerse notar en los años 1980 y abrió un taller con un personal de 30 ayudantes manejado de 
modo similar al célebre estudio de Andy Warhol conocido como The Factory. Koons es un 
empresario especulador que supo publicitar su obra y que le llevó a contratar los servicios 
de una agencia de publicidad. Jeff Koons aparece como artista en la década de los 80, en 
plena época consumista, donde la exaltación de lo superfluo es evidente. De todo el gran 
ámbito consumista surge su obra, la cual pretende conmover y criticar esto de forma 
perturbadora y a la vez con un toque de humor un tanto malévolo. Utiliza objetos cotidianos y 
de valor mínimo para conseguir su objetivo, al igual que hizo Duchamp, colocándolos en 
galerías iluminados y carentes de su antigua función.
También son frecuentes en algunas de sus obras chicas pin up, juguetes hinchables y demás 
objetos de la clase media. La idea es la principal característica que debe coronar a la obra.
Sus objetos provocan una especie de burla la cual va encaminada directamente hacia la 
influencia de la mayoría de la población por los mass media y la publicidad. Sorprendentemente 
a través de la publicidad, la cual enmarca como provocante de la actitud de la masa, se hace 
un importante hueco para tratar sobre los sueños de la clase media y la búsqueda ansiada de 
fama, dinero y estilo de vida. 
Para él la clase media siempre pensó en lo efímero , se bastó de lo más simple para su 
convención. Trabajó con Lady Gaga diseñando la portada de ARTPOP. ', 'Pintor, Escultor');

INSERT INTO 'autores' ('id_autor', 'ape_nom', 'fecha_nac', 'nacionalidad', 'telefono', 'e_mail', 'biografia', 'destreza') 
VALUES('AUT003', 'Alex Katz', '1931-06-24', 'Estados Unidos', 695853215, 'akatzalexka@gmail.com', 
'De familia judía, en 1928, la familia se mudó a St. Albans, Queens , donde creció Katz. 
De 1946 a 1949 Katz estudió en The Cooper Union en Nueva York. De 1949 a 1950 estudió en la 
Escuela de Pintura y Escultura de Skowhegan,Maine. Skowhegan lo expuso a la pintura de la 
vida, lo que resultaría fundamental en su desarrollo como pintor y sigue siendo un elemento 
básico de sus prácticas actuales. Katz explica que la pintura aérea de Skowhegan le dio una 
razón para dedicar mi vida a la pintura. Todos los años, desde principios de junio hasta 
mediados de septiembre, Katz se muda de su buhardilla SoHo a una granja de tablillas del 
siglo XIX en Lincolnville, Maine . Residente de Lincolnville desde 1954, ha desarrollado una 
relación cercana con el Colegio Colby local.  
De 1954 a 1960, realizó varios collages de naturalezas muertas, paisajes de Maine y pequeñas 
figuras. Conoció a Ada Del Moro , quien había estudiado biología en la Universidad de Nueva 
York , en una galería que abrió en 1957.  En 1960, Katz tuvo su primer (y único) hijo, Vincent 
Katz. Vincent Katz tuvo dos hijos, Isaac y Oliver, que han sido los sujetos de las pinturas 
de Katz. Katz ha admitido haber destruido mil pinturas durante sus primeros diez años como 
pintor para encontrar su estilo. Desde la década de 1950, trabajó para crear arte más 
libremente en el sentido de que trató de pintar más rápido de lo que [él] puede pensar. Sus 
obras parecen simples, pero según Katz son más reductoras , lo cual es apropiado para su 
personalidad. 
Exposiciones: Desde 1951, el trabajo de Alex Katz ha sido objeto de más de 200 exposiciones 
individuales y cerca de 500 exposiciones colectivas en todo Estados Unidos e 
internacionalmente. La primera exposición individual de Katz fue una exposición de pinturas 
en la Roko Gallery de Nueva York en 1954. En 1974, el Museo Whitney de Arte Americano mostró 
Alex Katz Prints, seguido de una exposición retrospectiva de pinturas y recortes, titulada 
Alex. Katz en 1986. 
El tema de más de 200 exposiciones individuales y casi 500 exposiciones colectivas a nivel 
internacional, Katz ha sido honrado con numerosas retrospectivas en museos como el Whitney 
Museum of American Art , Nueva York;Museo de Brooklyn , Nueva York; el Museo Judío de Nueva 
York; el Museo Irlandés de Arte Moderno , Dublín; Colby College Museum of Art , Maine; 
Staaliche Kunsthalle, Baden-Baden; Fondazione Bevilacqua La Masa, Venecia, Centro de Arte 
Contemporáneo de Málaga y la Galería Saatchi , Londres (1998). 
En 1998, se realizó un estudio de las pinturas de paisajes de Katz en el Centro de Arte 
Contemporáneo PS 1 , con casi 40 pinturas de motivos urbanos o pastorales. Katz está 
representada por Gavin Brown Enterprise en Nueva York, Timothy Taylor Gallery en Londres y 
Galerie Thaddaeus Ropac en París Salzburgo. Antes de mostrar con Brown, había estado 
representado por Pace Gallery durante 10 años y por Marlborough Gallerydurante 30 años. 
Las impresiones de Alex Katz se distribuyen en Europa por GALERIE FRANK FLUEGEL Nürnberg.', 'Pintor, Escultor');

INSERT INTO 'autores' ('id_autor', 'ape_nom', 'fecha_nac', 'nacionalidad', 'telefono', 'e_mail', 'biografia', 'destreza') 
VALUES('AUT004', 'Alfonso Albacete', '1950-02-01', 'Español', 632587456, 'alfonsoalbacete@gmail.com', 
'Alfonso Albacete, nacido en Antequera (Málaga), en 1950, se trasladó muy joven con su 
familia a Murcia, donde fue discípulo de Juan Bonafé. Sus primeras exposiciones individuales 
tuvieron lugar a principios de los años setenta en Murcia, Madrid, Sevilla o Valencia. 
Asistió al Círculo de Bellas Artes de Valencia, prosiguiendo sus estudios en la Escuela 
Superior de Arquitectura de Madrid. En 1977, con la carrera terminada, retomó en plenitud la 
pintura y en 1979 realizó en la madrileña galería Egam una exposición individual que le dio a 
conocer.1EstéticaAlbacete pertenece por generación a la nómina de finales de los años setenta 
(Campano, Quejido, Pérez Villalta, Pérez Mínguez, Alcolea, Franco, Gordillo, Cobo y Molero). 
Una generación que fue abandonando experiencias conceptuales anteriores para volver a la 
pintura desde la perspectiva proporcionada por las vanguardias históricas y las recientes 
abstracciones. 
Albacete, que transitará desde entonces entre la figuración y la abstracción, se sintió 
especialmente impactado por el expresionismo abstracto estadounidense y por artistas como 
Jasper Johns, Richard Diebenkorn o Helen Frankenthaler. El rico cromatismo y la firme 
estructuración de sus composiciones con figuras y espacios muy luminosos, dan a sus 
composiciones una impronta característica.', 'Grabado, serigrafía , Pintura');

INSERT INTO 'autores' ('id_autor', 'ape_nom', 'fecha_nac', 'nacionalidad', 'telefono', 'e_mail', 'biografia', 'destreza')
VALUES('AUT005', 'Yoyoi Kusama', '1939-03-22', 'Japón', 632589654, 'yoyoikusama@gmail.com', 
'A lo largo de su carrera, ha trabajado con una gran variedad de medios incluyendo: pintura, 
collage, escultura, arte performance e instalaciones, la mayoría de los cuales exhiben su 
interés temático en la psicodelia, la repetición y los patrones. Kusama es una precursora 
de los movimientos del arte pop, minimalismo y arte feminista e influenció a sus 
contemporáneos, Andy Warhol y Claes Oldenburg. 
A pesar de haber sido olvidada después de que dejó la escena del arte neoyorquino a principios
de la década de 1970, Kusama es reconocida actualmente como una de las artistas más 
importantes que haya salido de Japón y una voz muy importante del avant-garde. Vida temprana: 
1949. Nacida en Matsumoto (Nagano), fue la cuarta hija de una familia próspera y conservadora, 
cuyo bonanza provino de la venta de granos. Confiesa que cuando era pequeña sufrió de abuso 
físico por parte de su madre. En 1948, se fue de su hogar para entrar en la Escuela Municipal 
de Artes y Artesanías de Kyoto.
Éxito temprano en Japón: 1950–1958 Para 1950, Kusama representaba formas naturales abstraídas 
en acuarela, gouache y aceite en papel, principalmente. Desde 1963, Kusama ha continuado su 
serie de cuartos Espejo/Infinito. Nueva York: 1957–1972. En 1957 se mudó a Seattle, donde 
exhibió sus pinturas en la galería Zoe Dusanne. Durante su estancia en Estados Unidos, se 
granjeó reputación como líder en el movimiento avant-garde.
En 1961 se instaló en su estudio en el mismo edificio que Donald Judd y de la escultora Eva 
Hesse. 
En 1966, Kusama participó por primera vez en la Bienal de Venecia número 33. Su Jardín de 
Narciso constaba de cientos de esferas espejadas situadas en el exterior en lo que ella 
llamaba alfombra cinética.', 'Pintura, Escultura');

INSERT INTO 'autores' ('id_autor', 'ape_nom', 'fecha_nac', 'nacionalidad', 'telefono', 'e_mail', 'biografia', 'destreza') 
VALUES('AUT006', 'Consuelo Hernández', '1948-08-16', 'España', 684532695, 'hernaconsu@gmail.com', 
'Consuelo Hernández es destacada y representativa pintora española figurativa en la corriente
del Realismo. Artista con gran relevancia internacional. Diversos críticos de arte, como 
Mario Antolín, José María Bermejo, José Marín Medina, han enmarcado su obra dentro del 
denominado realismo madrileño y realismo poético. Con una sólida formación en los campos del 
Arte y de la Literatura, desde su infancia y adolescencia alterna los estudios de Bachillerato
y de Dibujo y Pintura. 
Licenciada a los 22 años en Filosofía y Letras por la Universidad de Salamanca. En su carrera 
artística puede observarse que Consuelo Hernández ha ido experimentando una evolución en 
cuanto a la técnica utilizada y en cuanto al contenido de su obra, que es reflejo de su 
propia evolución vital y la del entorno que la rodea.
Hay que destacar los seis años de su estancia en Tánger (1997-2003), época en la que sus 
pinturas se inspiran en la arquitectura decadente de la época internacional de la ciudad, 
en especial las que dedica al Teatro En 2012  presentó una selección de pinturas en el 
marco del Present Art Festival internacional, Contemporary art, que se exhibió en la 
Biblioteca Nacional de Shanghái Pudong y en el CEIBS (Art Investment Forum) de Shanghái 
(China). 
En 2015 la Diputación de Salamanca organizó  en el  espacio del Palacio de la Salina de la 
misma ciudad con gran repercusión en el público y en los medios. En abril de 2016 la 
institución Foro Europa 2001 le otorgó el galardón Medalla de Oro a la trayectoria artística. 
En julio de 2016 fue nuevamente reconocida (con la intervención de un jurado formado por once 
críticos de arte, historiadores y arquitectos italianos) por la prestigiosa  galería Satura 
Art Gallery de Génova (Italia) como artista invitada y premiada en el 2º Concurso 
Internazionale de arte contemporaneo. La muestra tuvo lugar en el espacio expositivo del 
Palazzo Stella de Génova, sede de la galería. 
En septiembre de 2016 ha participado de nuevo como artista invitada en el 21º Concorso 
Nazionale de Arte Contemporanea, organizado por Satura Art Gallery, Palazzo Stella, 
Génova (Italia). La muestra permaneció abierta desde el 10 al 24 de septiembre. 
Artista invitada en diciembre de 2016 a participar en el XIII Salón internacional
de artes plásticas de Sant Joan Les Fonts (Gerona). Premiada con trofeo y diploma Premio de 
honor. Nuevamente invitada en junio de 2017 al importante evento artístico, la 2ª Biennale di
Arte de Génova, Esposizione Internazionale de Arte Contemporanea, con la intervención y 
patrocinio de diversas instituciones de la ciudad y de la región de Liguria. 
Su obra Café Central ha merecido En diciembre de 2018 un jurado de críticos y comisarios 
de arte italianos presidido por los doctores Francesco Saverio Russo y Salvatore Russo le 
otorgan el International Prize Caravaggio. Acto de entrega: Milán (Italia), Teatro Litta.
Febrero de 2019: premiada nuevamente en Florencia (Italia)  por el mismo jurado italiano de 
críticos y comisarios de arte con el International Prize Botticelli en un solemne acto de 
entrega celebrado en el Palazzo Borghese de la misma ciudad.', 'Pintura');

INSERT INTO 'autores' ('id_autor', 'ape_nom', 'fecha_nac', 'nacionalidad', 'telefono', 'e_mail', 'biografia', 'destreza') 
VALUES('AUT007', 'Tatsuo Horiuchi', '1947-07-27', 'Japón', 627585537, 'Tatsuo.Horiuchi98@gmail.com', 
'Tatsuo Horiuchi no dedicó su vida íntegramente al arte, comenzó su andadura tras jubilarse,
cuando decidió retomar una de sus mayores aficiones: la pintura. Cuando se retiró, a Tatsuo 
Horiuchi le apetecía pintar, pero no podía invertir una fortuna en material, así que decidió
usar lo que ya tenía en casa y mejor sabía manejar: Excel. 
Años después, pinta unos cuadros tan espectaculares que nadie diría que se han creado con 
la popular aplicación de hoja de cálculo. 
Tatsuo se marcó un reto: lograr que en 10 años sus obras fueran lo bastante buenas como para 
mostrarlas al público y vaya si lo ha logrado. Su trabajo ha llegado hasta un extremo de 
complejidad que hace palidecer a cualquiera que esté familiarizado con cómo se crean objetos 
de colores en Excel. Sus cuadros hoy se exponen en galerías de arte e incluso pueden 
comprarse. 
El señor Horiuchi reconoce que son difíciles de vender, pero no le importa. Lo suyo es arte.', 'Pintura Digital');


INSERT INTO 'autores' ('id_autor', 'ape_nom', 'fecha_nac', 'nacionalidad', 'telefono', 'e_mail', 'biografia', 'destreza') 
VALUES('AUT008', 'Andrés Pachón', '1985-06-27', 'Español', 635987456, 'andresPach@gmail.com', 
'Andrés Pachón Arrones nace en 1985 en Madrid, donde reside actualmente. 
En 2008 se licencia en Bellas Artes por la U. C. M. – C. E. S. Felipe II de Aranjuez. 
Desde 2005 ha sido seleccionado en diversos certámenes nacionales, siendo entre ellos premio
e-Crea 2010, Lleida, y premio Adquisición 2012 en el V Premio Internacional Fundación María 
José Jové, de Galicia. En 2010 formó parte de la exposición «Fármaco de lo real». 
Ha participado en ferias internacionales como ArteSantander2010, Foro Sur 2011, JustMad 4 o 
ARCOmadrid 2014.
Formado en Arte Contemporáneo y en Antropología Social y Cultural. Durante los últimos años 
ha desarrollado una práctica visual sobre la construcción del imaginario colonial a través 
del uso de archivos fotográficos en antropología y etnografía. 
Para ello colaboró con instituciones como el Museé du Quai Branly de Paris, el Museo Nacional
de Antropología de Madrid, o el Archivo Fotográfico del Museo de Arte de Lima (MALI) en Perú. 
En sus trabajos reflexiona sobre la construcción del conocimiento a través de la fotografía, 
estableciendo relaciones entre las prácticas del s. XIX y XX, y los usos tecnológicos del 
presente, como es el caso de su actual investigación sobre la actividad sociotécnica de los 
sistemas de Visión Computacional por Inteligencia Artificial.Desde el año 2010 es representado 
por la Galería Ángeles Baños, Badajoz, donde realizó su primera individual en 2012. 
Desde entonces ha expuesto de manera individual en espacios como el Museo Nacional de 
Antropología de Madrid, el Centro de Arte Alcobendas, La New Gallery en Madrid, o Rodriguez 
Gallery en Polonia, entre otros. De forma colectiva cabe destacar su participación en “Colonia
Apócrifa” en el MUSAC, “Reencontres Internationales. New cinema and contemporary art 2014”, 
en Gaîté Lyrique y Palais de Tokyo en Paris, y “VIVA Collections on Tour 2013” en el Museo 
Lázaro Galdiano, Madrid. 
Ha participado en ferias internacionales como “ARCOmadrid 2014”, donde fue Premio de Arte 
Electrónico ARCO/BEEP por el proyecto “Tropologías II”, “Art15 London”, “Volta 11” en Basel 
y Estampa 2016 y 2018, en Madrid.Durante estos años ha recibido distintos premios y becas, 
entre los que destaca la beca “Transvisiones” en 2015, desarrollando una residencia en el 
Centro de la Imagen de Perú, Lima; o la Ayuda a la Creación en Artes Visuales de la 
Comunidad de Madrid en 2017 por el proyecto La Derrota del Rostro.Algunos de sus proyectos, 
como Tropologías, “Taxidermia” o “In Memoriam” han sido publicados en varias revistas y 
libros de interés, como el número P de la revista “MATADOR” (La Fábrica, 2014), o el libro 
“Arte Español Contemporáneo. 1992-2013” (La Fábrica, 2013).
Precisamente la manipulación de imágenes preexistentes con procedimientos tecnológicos es la 
base de su trabajo, su procedimiento para desvelarnos que las fotografías, así pasen las 
décadas, pueden ser puntos de partida para viajes de ida y vuelta en los que reflexionemos 
sobre el valor y las posibilidades del propio medio fotográfico y sobre nuestros modos de 
mirar, sobre todo de mirar lo diferente, fundamentalmente cuando el objeto de nuestra visión 
se nos muestra bajo la mediación de una vitrina o en un contexto museístico o de archivo. 
Utiliza herramientas digitales heredadas de la fotografía, como pueden ser los programas de 
postproducción o el modelado ·D, que les permiten desmontar la supuesta objetividad del
documento fotográfico.', 'Pintura, fotografía, cine');


INSERT INTO 'galerias' ('cif', 'nombre_gale', 'direccion_gale', 'telefono_gale') VALUES
('12345678B', 'Gallery of Fantastic Puzzles', 'Calle del Pintor, 
15 local 62', 916589325);


INSERT INTO 'obras' ('id_obra', 'titulo', 'tipo', 'tamanio', 'material', 'descripcion', 'precio', 'id_autor') 
VALUES
('AAB001','Planteamiento', 'Pintura', '100x140', 'Grabado', 
'El rico cromatismo y la firme estructuración de sus composiciones con figuras 
y espacios muy luminosos, dan a sus composiciones una impronta característica, 
inspirada en la naturaleza.', 2, 'AUT004');

INSERT INTO 'obras' ('id_obra', 'titulo', 'tipo', 'tamanio', 'material', 'descripcion', 'precio', 'id_autor') 
VALUES
('AAB002', 'SanMarino', 'Pintura', '73x54', 
'Serigrafia ne Lienzo', 
'El rico cromatismo y la firme estructuración de sus composiciones con figuras 
y espacios muy luminosos, dan a sus composiciones una impronta característica, 
inspirada en la naturaleza.', 800, 'AUT004');

INSERT INTO 'obras' ('id_obra', 'titulo', 'tipo', 'tamanio', 'material', 'descripcion', 'precio', 'id_autor') 
VALUES
('AAB003', 'Canal', 'Pintura', '80x120', 'Serigrafia', 
'El rico cromatismo y la firme estructuración de sus composiciones con figuras 
y espacios muy luminosos, dan a sus composiciones una impronta característica, 
inspirada en la naturaleza.', 850, 'AUT004');

INSERT INTO 'obras' ('id_obra', 'titulo', 'tipo', 'tamanio', 'material', 'descripcion', 'precio', 'id_autor') 
VALUES
('AAB004', 'Dehesa', 'Pintura', '120x160', 'Serigrafía', 
'El rico cromatismo y la firme estructuración de sus composiciones con figuras 
y espacios muy luminosos, dan a sus composiciones una impronta característica, 
inspirada en la naturaleza.', 8500, 'AUT004');

INSERT INTO 'obras' ('id_obra', 'titulo', 'tipo', 'tamanio', 'material', 'descripcion', 'precio', 'id_autor') 
VALUES
('AAB005', 'Primavera', 'Pintura', '30x30', 'Serigrafía', 
'El rico cromatismo y la firme estructuración de sus composiciones con figuras 
y espacios muy luminosos, dan a sus composiciones una impronta característica, 
inspirada en la naturaleza.', 8500, 'AUT004');

INSERT INTO 'obras' ('id_obra', 'titulo', 'tipo', 'tamanio', 'material', 'descripcion', 'precio', 'id_autor') 
VALUES
('AKT001', 'Eutheria', 'Pintura', '7,45x3,50', 'Oleo', 
'La obra de Katz se define por su forma y plenitud del color, su economía de la
línea, y su desapego emocional fresco, pero seductora. Trabajar con temas 
clásicos del retrato, paisaje, estudios de figuras, escenas marinas y flores, 
muchas de Katz trabaja todos los días la imagen de América de la vida fácil de 
ocio y recreación.', 126, 'AUT003');

INSERT INTO 'obras' ('id_obra', 'titulo', 'tipo', 'tamanio', 'material', 'descripcion', 'precio', 'id_autor') 
VALUES
('AKT002', 'PaintingTrees', 'Pintura', '120x90', 'Oleo', 
'La obra de Katz se define por su forma y plenitud del color, su economía de la 
línea, y su desapego emocional fresco, pero seductora. Trabajar con temas 
clásicos del retrato, paisaje, estudios de figuras, escenas marinas y flores, PRECIO:6000€', 6000, 'AUT003');

INSERT INTO 'obras' ('id_obra', 'titulo', 'tipo', 'tamanio', 'material', 'descripcion', 'precio', 'id_autor') 
VALUES('AKT003', 'Painting Gifts1', 'Pintura', '120x70', 'Oleo', 
'La obra de Katz se define por su forma y plenitud del color, su economía de la 
línea, y su desapego emocional fresco, pero seductora. Trabajar con temas 
clásicos del retrato, paisaje, estudios de figuras, escenas marinas y flores', 600, 'AUT003');

INSERT INTO 'obras' ('id_obra', 'titulo', 'tipo', 'tamanio', 'material', 'descripcion', 'precio', 'id_autor') 
VALUES('AKT004', 'Painting Gifts2', 'Pintura', '100x40', 'Oleo', 
'La obra de Katz se define por su forma y plenitud del color, su economía de la 
línea, y su desapego emocional fresco, pero seductora. Trabajar con temas 
clásicos del retrato, paisaje, estudios de figuras, escenas marinas y flores', 800, 'AUT003');

INSERT INTO 'obras' ('id_obra', 'titulo', 'tipo', 'tamanio', 'material', 'descripcion', 'precio', 'id_autor') 
VALUES
('APN001', 'Tiberias', 'Fotografia', '11x13', 'Papel', 
'La linterna mágica fue un artefacto para proyectar imágenes creado en el siglo
XVII; se trata de un precedente del cinematógrafo que se situaba a medio 
camino entre las recreaciones científicas,  las diversiones populares y los 
emergentes medios de  comunicación de masas, a medida que generaba un imaginario 
que filtraba la cultura visual occidental.Este trabajo se presenta como una 
del soporte fotográfico empleado en las últimas linternas mágicas: diapositivas 
de vidrio datadas entre 1890 y 1930, que en ocasiones, como en las placas que 
aquí se usan, eran pintadas a mano.Las diapositivas de linterna mágica aquí 
estudiadas responden a paisajes de las tierras sagradas del Antiguo y Nuevo 
Testamento (Holy Lands), donde el valor etnográfica de las fotografías se solapa 
con el imaginario bíblico.En Magic Lantern Vol. 1, las placas originales se 
presentan en un dispositivo que modifica la manera correcta de visionarlas, 
anulando la fotografía y mostrando exclusivamente la capa de la intervención 
pictórica. 
En Magic Lantern Vol. 2 se extrae digitalmente la capa pictórica de las placas, 
aislando la acuarela de la fotografía y recuperando el trazo de las pinceladas.
De esta manera nos situamos entre la capa del gesto manual y la capa de lo 
mecánico fotográfico, subrayando cómo el ojo occidental construye su imaginario 
bajo la falsa idea de objetividad atribuida al automatismo fotográfico, pues 
los paisajes ya no se originan en la experiencia directa de la naturaleza, si 
no en la experiencia de paisajes previos. En concreto, las placas que se 
analizan responden a paisajes de las tierras sagradas del Antiguo y Nuevo 
Testamento (Holy Lands), donde el valor etnográfico de las fotografías se solapa 
con el imaginario bíblico.No sabemos quién precede a quién, si la imagen
fotográfica a la pictórica o viceversa; definitivamente nuestra imagen del mundo
es la copia de una copia, un solapamiento de capas donde no tiene cabida el 
referente.', 3000, 'AUT008');

INSERT INTO 'obras' ('id_obra', 'titulo', 'tipo', 'tamanio', 'material', 'descripcion', 'precio', 'id_autor') 
VALUES
('APN002', 'Mount Hermon', 'Fotografía', '110x130', 'Papel', 
'La linterna mágica fue un artefacto para proyectar imágenes creado en el siglo
XVII; se trata de un precedente del cinematógrafo que se situaba a medio 
camino entre las recreaciones científicas,  las diversiones populares y los 
emergentes medios de  comunicación de masas, a medida que generaba un imaginario 
que filtraba la cultura visual occidental.Este trabajo se presenta como una 
del soporte fotográfico empleado en las últimas linternas mágicas: diapositivas 
de vidrio datadas entre 1890 y 1930, que en ocasiones, como en las placas que 
aquí se usan, eran pintadas a mano.Las diapositivas de linterna mágica aquí 
estudiadas responden a paisajes de las tierras sagradas del Antiguo y Nuevo 
Testamento (Holy Lands), donde el valor etnográfica de las fotografías se solapa 
con el imaginario bíblico.En Magic Lantern Vol. 1, las placas originales se 
presentan en un dispositivo que modifica la manera correcta de visionarlas, 
anulando la fotografía y mostrando exclusivamente la capa de la intervención 
pictórica. 
En Magic Lantern Vol. 2 se extrae digitalmente la capa pictórica de las placas, 
aislando la acuarela de la fotografía y recuperando el trazo de las pinceladas.
De esta manera nos situamos entre la capa del gesto manual y la capa de lo 
mecánico fotográfico, subrayando cómo el ojo occidental construye su imaginario 
bajo la falsa idea de objetividad atribuida al automatismo fotográfico, pues 
los paisajes ya no se originan en la experiencia directa de la naturaleza, si 
no en la experiencia de paisajes previos. En concreto, las placas que se 
analizan responden a paisajes de las tierras sagradas del Antiguo y Nuevo 
Testamento (Holy Lands), donde el valor etnográfico de las fotografías se solapa 
con el imaginario bíblico.No sabemos quién precede a quién, si la imagen
fotográfica a la pictórica o viceversa; definitivamente nuestra imagen del mundo
es la copia de una copia, un solapamiento de capas donde no tiene cabida el 
referente.', 2500, 'AUT008');

INSERT INTO 'obras' ('id_obra', 'titulo', 'tipo', 'tamanio', 'material', 'descripcion', 'precio', 'id_autor') 
VALUES
('APN003', 'Bethany', 'Fotografia', '110x130', 'Papel', 
'La linterna mágica fue un artefacto para proyectar imágenes creado en el siglo
XVII; se trata de un precedente del cinematógrafo que se situaba a medio 
camino entre las recreaciones científicas,  las diversiones populares y los 
emergentes medios de  comunicación de masas, a medida que generaba un imaginario 
que filtraba la cultura visual occidental.Este trabajo se presenta como una 
del soporte fotográfico empleado en las últimas linternas mágicas: diapositivas 
de vidrio datadas entre 1890 y 1930, que en ocasiones, como en las placas que 
aquí se usan, eran pintadas a mano.Las diapositivas de linterna mágica aquí 
estudiadas responden a paisajes de las tierras sagradas del Antiguo y Nuevo 
Testamento (Holy Lands), donde el valor etnográfica de las fotografías se solapa 
con el imaginario bíblico.En Magic Lantern Vol. 1, las placas originales se 
presentan en un dispositivo que modifica la manera correcta de visionarlas, 
anulando la fotografía y mostrando exclusivamente la capa de la intervención 
pictórica. 
En Magic Lantern Vol. 2 se extrae digitalmente la capa pictórica de las placas, 
aislando la acuarela de la fotografía y recuperando el trazo de las pinceladas.
De esta manera nos situamos entre la capa del gesto manual y la capa de lo 
mecánico fotográfico, subrayando cómo el ojo occidental construye su imaginario 
bajo la falsa idea de objetividad atribuida al automatismo fotográfico, pues 
los paisajes ya no se originan en la experiencia directa de la naturaleza, si 
no en la experiencia de paisajes previos. En concreto, las placas que se 
analizan responden a paisajes de las tierras sagradas del Antiguo y Nuevo 
Testamento (Holy Lands), donde el valor etnográfico de las fotografías se solapa 
con el imaginario bíblico.No sabemos quién precede a quién, si la imagen
fotográfica a la pictórica o viceversa; definitivamente nuestra imagen del mundo
es la copia de una copia, un solapamiento de capas donde no tiene cabida el 
referente.', 3000, 'AUT008');

INSERT INTO 'obras' ('id_obra', 'titulo', 'tipo', 'tamanio', 'material', 'descripcion', 'precio', 'id_autor') 
VALUES('CH001', ' Niebla en el Jardin', 'Pintura', '120x81', 'Oleo', 
'Artista residente en Madrid, en la línea del Realismo pictórico. 
Con una extensa trayectoria pictórica su primera exposición individual la 
realiza en 1980. Desde una incipiente tendencia impresionista en sus obras, 
fue evolucionando hacia un tipo de realismo poético que se inspira en la 
realidad de su entorno cotidiano. Ha expuesto en ferias internacionales de 
arte: de Chicago, de Hong Kong, de Singapur, de París, La Haya, etc.', 1500, 'AUT006');

INSERT INTO 'obras' ('id_obra', 'titulo', 'tipo', 'tamanio', 'material', 'descripcion', 'precio', 'id_autor') 
VALUES
('CHZ002', 'Boulevar Pasteur', 'Pintura', '116x81', 'Oleo', 
'Artista residente en Madrid, en la línea del Realismo pictórico. 
Con una extensa trayectoria pictórica su primera exposición individual la 
realiza en 1980. Desde una incipiente tendencia impresionista en sus obras, 
fue evolucionando hacia un tipo de realismo poético que se inspira en la 
realidad de su entorno cotidiano. Ha expuesto en ferias internacionales de 
arte: de Chicago, de Hong Kong, de Singapur, de París, La Haya, etc.', 15000, 'AUT006');

INSERT INTO 'obras' ('id_obra', 'titulo', 'tipo', 'tamanio', 'material', 'descripcion', 'precio', 'id_autor') 
VALUES
('CHZ003', 'El Hafa','Pintura', '120x81', 'Oleo', 
'Artista residente en Madrid, en la línea del Realismo pictórico. 
Con una extensa trayectoria pictórica su primera exposición individual la 
realiza en 1980. Desde una incipiente tendencia impresionista en sus obras, 
fue evolucionando hacia un tipo de realismo poético que se inspira en la 
realidad de su entorno cotidiano. Ha expuesto en ferias internacionales de 
arte: de Chicago, de Hong Kong, de Singapur, de París, La Haya, etc.', 2000, 'AUT006');

INSERT INTO 'obras' ('id_obra', 'titulo', 'tipo', 'tamanio', 'material', 'descripcion', 'precio', 'id_autor') 
VALUES
('JKS001', 'BallonDog2', 'Escultura', '381x596', 'Acero inoxidable', 
'La obra más conocida de las esculturas globo es Balloon Dog. Las esculturas
de globos de animales son su mayor creación sobre todo la que representa a un 
perro de globo inflado en color naranja, está realizada en acero y según Koons:
"Es un símbolo, como el caballo de Troya, tiene algo mítico". $58.405.000 
(43.400.000 €) es la cantidad que alcanzó la escultura Balloon Dog (Naranja) 
del provocador artista PopArt, Jeff Koons, superando las expectativas más 
optimistas que creían que podría venderse por entre 35 y 55 millones de dólares, 
se subastó en una subasta de Christie en la ciudad de Nueva York. Esta escultura 
rompió el récord mundial de la obra de arte más cara vendida de un artista en 
vida. De 12 pies de altura es un juguete infantil de gran tamaño, es una de 5 
exclusivas piezas de perro metálicas hechas por Jeff Koons (las otras cuatro son 
de color amarillo, azul, magenta y rojo), propiedad de los mega millonarios 
financistas y coleccionistas de arte: Steven A. Cohen, Eli Broad (cuyo Balloon 
Dog (Azul) está en exhibición en el Museo de Arte Contemporáneo The Broad en Los 
Ángeles, Francois Pinault y Dakis Joannou. La escultura de acero inoxidable con 
recubrimiento de color transparente es uno de los primeros perros del globo, 
que se parecen el tipo de souvenires payasos hacen en fiestas de cumpleaños', 14250, 'AUT002');

INSERT INTO 'obras' ('id_obra', 'titulo', 'tipo', 'tamanio', 'material', 'descripcion', 'precio', 'id_autor') 
VALUES
('JKS002', 'BallonDog2', 'Escultura', '381x596', 'Acero Inoxidable', 
'La obra más conocida de las esculturas globo es Balloon Dog. Las esculturas
de globos de animales son su mayor creación sobre todo la que representa a un 
perro de globo inflado en color naranja, está realizada en acero y según Koons:
"Es un símbolo, como el caballo de Troya, tiene algo mítico". $58.405.000 
(43.400.000 €) es la cantidad que alcanzó la escultura Balloon Dog (Naranja) 
del provocador artista PopArt, Jeff Koons, superando las expectativas más 
optimistas que creían que podría venderse por entre 35 y 55 millones de dólares, 
se subastó en una subasta de Christie en la ciudad de Nueva York. Esta escultura 
rompió el récord mundial de la obra de arte más cara vendida de un artista en 
vida. De 12 pies de altura es un juguete infantil de gran tamaño, es una de 5 
exclusivas piezas de perro metálicas hechas por Jeff Koons (las otras cuatro son 
de color amarillo, azul, magenta y rojo), propiedad de los mega millonarios 
financistas y coleccionistas de arte: Steven A. Cohen, Eli Broad (cuyo Balloon 
Dog (Azul) está en exhibición en el Museo de Arte Contemporáneo The Broad en Los 
Ángeles, Francois Pinault y Dakis Joannou. La escultura de acero inoxidable con 
recubrimiento de color transparente es uno de los primeros perros del globo, 
que se parecen el tipo de souvenires payasos hacen en fiestas de cumpleaños', 14250, 'AUT002');


INSERT INTO 'obras' ('id_obra', 'titulo', 'tipo', 'tamanio', 'material', 'descripcion', 'precio', 'id_autor') 
VALUES
('JKS003', 'BallonDog3', 'Escultura', '381x596', 'Acero inoxidable', 
'La obra más conocida de las esculturas globo es Balloon Dog. Las esculturas
de globos de animales son su mayor creación sobre todo la que representa a un 
perro de globo inflado en color naranja, está realizada en acero y según Koons:
"Es un símbolo, como el caballo de Troya, tiene algo mítico". $58.405.000 
(43.400.000 €) es la cantidad que alcanzó la escultura Balloon Dog (Naranja) 
del provocador artista PopArt, Jeff Koons, superando las expectativas más 
optimistas que creían que podría venderse por entre 35 y 55 millones de dólares, 
se subastó en una subasta de Christie en la ciudad de Nueva York. Esta escultura 
rompió el récord mundial de la obra de arte más cara vendida de un artista en 
vida. De 12 pies de altura es un juguete infantil de gran tamaño, es una de 5 
exclusivas piezas de perro metálicas hechas por Jeff Koons (las otras cuatro son 
de color amarillo, azul, magenta y rojo), propiedad de los mega millonarios 
financistas y coleccionistas de arte: Steven A. Cohen, Eli Broad (cuyo Balloon 
Dog (Azul) está en exhibición en el Museo de Arte Contemporáneo The Broad en Los 
Ángeles, Francois Pinault y Dakis Joannou. La escultura de acero inoxidable con 
recubrimiento de color transparente es uno de los primeros perros del globo, 
que se parecen el tipo de souvenires payasos hacen en fiestas de cumpleaños', 14000, 'AUT002');

INSERT INTO 'obras' ('id_obra', 'titulo', 'tipo', 'tamanio', 'material', 'descripcion', 'precio', 'id_autor') 
VALUES
('JKS004', 'BallonMonkey', 'Escultura', 
'381x596', 'Acero Inoxidable', 
'La obra más conocida de las esculturas globo es Balloon Dog. Las esculturas
de globos de animales son su mayor creación sobre todo la que representa a un 
perro de globo inflado en color naranja, está realizada en acero y según Koons:
"Es un símbolo, como el caballo de Troya, tiene algo mítico". $58.405.000 
(43.400.000 €) es la cantidad que alcanzó la escultura Balloon Dog (Naranja) 
del provocador artista PopArt, Jeff Koons, superando las expectativas más 
optimistas que creían que podría venderse por entre 35 y 55 millones de dólares, 
se subastó en una subasta de Christie en la ciudad de Nueva York. Esta escultura 
rompió el récord mundial de la obra de arte más cara vendida de un artista en 
vida. De 12 pies de altura es un juguete infantil de gran tamaño, es una de 5 
exclusivas piezas de perro metálicas hechas por Jeff Koons (las otras cuatro son 
de color amarillo, azul, magenta y rojo), propiedad de los mega millonarios 
financistas y coleccionistas de arte: Steven A. Cohen, Eli Broad (cuyo Balloon 
Dog (Azul) está en exhibición en el Museo de Arte Contemporáneo The Broad en Los 
Ángeles, Francois Pinault y Dakis Joannou. La escultura de acero inoxidable con 
recubrimiento de color transparente es uno de los primeros perros del globo, 
que se parecen el tipo de souvenires payasos hacen en fiestas de cumpleaños', 15000, 'AUT002');


INSERT INTO 'obras' ('id_obra', 'titulo', 'tipo', 'tamanio', 'material', 'descripcion', 'precio', 'id_autor') 
VALUES
('OAW001', 'Grapes', 'Escultura', '1500x1087', 'Madera', 
'El artista, arquitecto, curador y activista chino Ai Weiwei a menudo trabaja
con acumulaciones masivas de objetos individuales, incluidos elementos tan 
diversos como bicicletas, semillas de girasol, mochilas, chalecos salvavidas y 
cangrejos. El significado histórico y cultural de los materiales que utiliza 
Ai es un elemento esencial de casi todas sus esculturas. Grapes  es un trabajo 
exclusivo de Ai compuesto por 26 banquetas de la dinastía Qing (1644-1911). 
El taburete de madera de tres patas común es un objeto doméstico anticuado en 
la sociedad china actual. Todas las casas tenían taburetes de madera de diseño 
clásico que se transmitían por generaciones, pero han sido reemplazados por 
variaciones de plástico y aluminio a medida que China se moderniza. 
Desde 1997, Ai ha recolectado estos taburetes de madera artesanales únicos y ha 
creado una gran variedad de esculturas e instalaciones con ellos. 
Esta acumulación escultórica de taburetes antiguos se centra en cuestiones 
relacionadas con la exportación de valores culturales y el conocimiento histórico, 
el choque entre ideas antiguas y nuevas en China y los mercados internacionales 
de arte y antigüedades. Las uvas  sirven como una metáfora sobre la historia 
socialista de China, que requiere que el individuo deje de lado sus intereses 
personales en favor de los del grupo más grande, o el estado.', 2000, 'AUT001');

INSERT INTO 'obras' ('id_obra', 'titulo', 'tipo', 'tamanio', 'material', 'descripcion', 'precio', 'id_autor') 
VALUES
('OAW002', 'DivinaProporcion', 'Escultura', '1.69', 'Madera Palisandro', 
'El artista y coleccionista chino Ai Weiwei ha utilizado la madera de 
palisandro amarillo, tan apreciada, para construir esculturas 
poliédricas siguiendo la técnica tradicional de ensamblaje de las piezas,
sin utilizar clavos, tornillos ni pegamento.Las esculturas tienen forma de 
icosaedro truncado, con 12 caras pentagonales y 20 caras hexagonales. 
La ha bautizado Divine Proportion haciendo referencia al libro del matemático 
italiano Luca Pacioli titulado De Divina Proportione (1509) que fue ilustrado 
por Leonardo da Vinci con varios poliedros. Uno de ellos precisamente era el 
icosaedro truncado que Ai Weiwei copió del juguete de su gato; al ver por 
casualidad la lámina de Leonardo en un libro de arte no tuvo duda en darle 
el guiño “divino” a su obra.', 2000, 'AUT001');


INSERT INTO 'obras' ('id_obra', 'titulo', 'tipo', 'tamanio', 'material', 'descripcion', 'precio', 'id_autor') 
VALUES
('OAW003', ' HeXie/Cangrejos', 
'Escultura', '3.200', 'Porcelana', 
'Uno de los formatos más extendidos en la obra de Ai Wei Wei son las 
instalaciones. En estas piezas entre las estrategias contemporáneas y las 
tradiciones chinas, con estos cangrejos de porcelana, esta pieza explora 
la relación de la idiosincrasia de su país con ese material, al tiempo que 
alude a problemas en el régimen comunista. Su nombre original HeiXie, es la 
palabra china que alude al cangrejo y se utiliza como sinónimo de arminioso,
además en el slang digital se aplica a la tarea de los censores de internet.', 3000, 'AUT001');

INSERT INTO 'obras' ('id_obra', 'titulo', 'tipo', 'tamanio', 'material', 'descripcion', 'precio', 'id_autor') 
VALUES
('THI001', 'Mujer con Sombrilla', 'Imp Digita', '699x477', 'Impresión', 
'El artista japonés Tatsuo Horiuchi lleva 15 años representando con maestría 
imágenes de cerezos en flor, bosques frondosos y montañas nevadas y, todo ello, 
valiéndose de una herramienta bastante inusual: Microsoft Excel.
El ilustrador de 77 años rechazó la idea de invertir en pinturas caras o incluso
en programas de ordenador asegurando que prefiere trabajar con Excel antes que 
con Paint o cualquier otro ya que, según aclara, “tiene más funciones y es más 
sencillo”. Utilizando la herramienta de dibujar vectores pensada en un principio 
para elaborar gráficos, Horiuchi “pinta” escenas paisajísticas de la vida rural 
de Japón.En esta obra trata de representar la calma y tranquilidad que despierta 
un paseo por el margen de un lago de una mujer japonesa.Su trabajo fue adquirido 
íntegramente por el Museo de Arte de Gunma, las únicas obras cedidas a la venta 
se exponen en esta galería.', 3000, 'AUT007');

INSERT INTO 'obras' ('id_obra', 'titulo', 'tipo', 'tamanio', 'material', 'descripcion', 'precio', 'id_autor') 
VALUES
('THI002', 'Niño Encantado', 'Imp Digita', '961x586', 'Impresion', 
'El ilustrador de 77 años utiliza la herramienta de dibujar vectores pensada en
un principio para elaborar gráficos, y “pinta” escenas paisajísticas de la vida 
rural de Japón. Hoy, los cuadros de Horiuchi son auténticos ejercicios de 
virtuosismo pictórico (si pensamos que han sido realizados en Excel): el grado 
de detalle, las capas de colores, la viveza de las imágenes retratadas y la 
tranquilidad y el sosiego que transmiten son algunas de sus principales virtudes. 
Por supuesto, muchos de estos lienzos han sido impresos y expuestos, y él mismo 
los guarda en su casa. En esta obra, Tatsuo muestra la alegría de un niño que 
ve el primer amanecer del nuevo año.', 2500, 'AUT007');

INSERT INTO 'obras' ('id_obra', 'titulo', 'tipo', 'tamanio', 'material', 'descripcion', 'precio', 'id_autor') 
VALUES
('THI004', 'Temperatura', 'ImpDigital', '1227x867', 'Impresion', 
'El artista japonés Tatsuo Horiuchi lleva 15 años representando con maestría 
imágenes de cerezos en flor, bosques frondosos y montañas nevadas y, todo 
ello, valiéndose de una herramienta bastante inusual: Microsoft Excel. 
El ilustrador de 77 años rechazó la idea de invertir en pinturas caras o incluso
en programas de ordenador asegurando que prefiere trabajar con Excel antes que 
con Paint o cualquier otro ya que, según aclara, “tiene más funciones y es más 
sencillo”. Utilizando la herramienta de dibujar vectores pensada en un principio 
para elaborar gráficos, Horiuchi “pinta” escenas paisajísticas de la vida rural 
de Japón. En esta obra, Horiuchi refleja la llegada de la primavera, momento en 
el que el agua comienza a calentarse.', 14000, 'AUT007');

INSERT INTO 'obras' ('id_obra', 'titulo', 'tipo', 'tamanio', 'material', 'descripcion', 'precio', 'id_autor') 
VALUES
('THI005', 'Yaezakura', 'Imp Digita', '1128x672', 'Impresion', 
'Utilización de figuras, vectores y degradados (una opción que todos los niños
de los noventa recordarán con agrado), herramienta que le permite dibujar 
hojas de colores otoñales y cisnes de aspecto señorial. La sencilla función de 
relleno y el carácter estable de las casillas de Excel, modificables y 
virtualmente infinitas, hicieron el resto.
Esta imagen del monte Fuji con vistas a la montaña a través de las flores de 
cerezo en flor, es de una belleza singular.', 3000, 'AUT007');

INSERT INTO 'obras' ('id_obra', 'titulo', 'tipo', 'tamanio', 'material', 'descripcion', 'precio', 'id_autor') 
VALUES
('THI006', 'Mar de Sado', 'Imp Digita', '1204x595', 'Impresion', 
'El ilustrador de 77 años utiliza la herramienta de dibujar vectores pensada en
un principio para elaborar gráficos, y “pinta” escenas paisajísticas de la vida 
rural de Japón. Hoy, los cuadros de Horiuchi son auténticos ejercicios de 
virtuosismo pictórico (si pensamos que han sido realizados en Excel): el grado 
de detalle, las capas de colores, la viveza de las imágenes retratadas y la 
tranquilidad y el sosiego que transmiten son algunas de sus principales virtudes. 
Por supuesto, muchos de estos lienzos han sido impresos y expuestos, y él mismo
los guarda en su casa.
Sado tiene un área de playa cerca de la orilla de la playa, un tifón de verano y 
una cordillera que se parece a ella. El transbordador de Ogi se estremeció con 
el tronar de las olas.', 3, 'AUT007');

INSERT INTO 'obras' ('id_obra', 'titulo', 'tipo', 'tamanio', 'material', 'descripcion', 'precio', 'id_autor') 
VALUES
('THI007', 'Tatara', 'Imp Digta', '278x1164', 'Impresion', 
'El artista japonés Tatsuo Horiuchi, de 77 años de edad, lleva 15 años 
representando con maestría imágenes realizadas en Excel.Su técnica es su 
secreto, pero hay algunos trucos que sí han salido a la luz gracias a su 
especial talento. El principal es la utilización de figuras, vectores y 
degradados (una opción que todos los niños de los noventa recordarán con
agrado), herramienta que le permite dibujar hojas de colores otoñales y 
cisnes de aspecto señorial. La sencilla función de relleno y el carácter 
estable de las casillas de Excel, modificables y virtualmente infinitas, 
hicieron el resto. 
En esta imagen se plasma la belleza del Parque rural Tatara, en primavera.', 3, 'AUT007');

INSERT INTO 'obras' ('id_obra', 'titulo', 'tipo', 'tamanio', 'material', 'descripcion', 'precio', 'id_autor') 
VALUES
('YKA001', 'Desing Bridge', 'Pintura', '150x150', 'Oleo', 
'El 10 de junio, la Galería Nacional de Singapur inauguró Yayoi Kusama: La vida
es el corazón de un arco iris para un público muy emocionado y ansioso. Es la 
primera exposición importante de su trabajo en el sudeste asiático y, como es 
lógico, muchos de nosotros fuimos a verla durante el primer fin de semana. 
¿Quién no estaría emocionado por unas horas de inspiración y diversión inmersiva?
Viajamos con Kusama a través de 120 obras de arte en varias galerías. Vimos su 
crecimiento como artista a través de la variada colección de pinturas, esculturas, 
instalaciones y videos de performance.
Puntos y patrones repetidos siempre han sido sinónimo de Kusama. Han sido un motivo 
claro para esta artista influyente incluso en sus primeros años.', 2, 'AUT005');

INSERT INTO 'obras' ('id_obra', 'titulo', 'tipo', 'tamanio', 'material', 'descripcion', 'precio', 'id_autor') 
VALUES
('YKA002', 'Field Trip', 'Pintura', '150x180', 'Oleo', 
'La primera vez que escuché sobre el trabajo de Yayoi Kusama fue en un espectáculo
reciente que tuvo en Nueva York de una habitación totalmente blanca que cambiaría 
con el tiempo, ya que cada persona que ingresara colocaría una colorida calcomanía 
circular donde quisiera. ¿Cuan genial es eso? Pensé. Arte que cambia con el 
tiempo. Arte que no siempre es creado por el artista, sino también por los 
espectadores.  Me intrigó y necesitaba saber más. Aprendí que Kusama ha jugado 
con el concepto de infinito durante muchas décadas y en una variedad de medios. 
La exposición itinerante marca el debut en América del Norte de numerosas obras 
nuevas de la artista de 88 años, que todavía está creando activamente en su 
estudio de Tokio.
Cuando me enteré de que la exposición viajaba a Los Ángeles, fue una visita obligada 
para un viaje de campo del equipo Oh Joy al museo Broad para ver la exposición de 
Yayoi Kusama ...', 3000, 'AUT005');

