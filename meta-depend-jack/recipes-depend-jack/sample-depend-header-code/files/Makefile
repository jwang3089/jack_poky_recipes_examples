obj = main1.o
target = hello-world1

INCLUDE=include

all: $(obj)
	${CC} ${CFLAGS} $(obj) -o $(target)

%.o:%.c
	${CC} ${CFLAGS} -c $^ -o $@

.PHONY: clean
clean:
	rm -rf $(obj) $(target)
