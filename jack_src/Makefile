obj = main7.o
target = hello-world7

INCLUDE=include

all: $(obj)
	${CC} ${CFLAGS} $(obj) -o $(target)

%.o:%.c
	${CC} ${CFLAGS} -c $^ -o $@

.PHONY: clean
clean:
	rm -rf $(obj) $(target)
