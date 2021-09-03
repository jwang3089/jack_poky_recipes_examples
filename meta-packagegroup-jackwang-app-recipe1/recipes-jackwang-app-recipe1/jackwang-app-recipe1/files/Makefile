obj = app-recipe1.o
target = app-recipe1 

INCLUDE=include

all: $(obj)
	${CC} ${CFLAGS} $(obj) -o $(target)

%.o:%.c
	${CC} ${CFLAGS} -c $^ -o $@

.PHONY: clean
clean:
	rm -rf $(obj) $(target)
