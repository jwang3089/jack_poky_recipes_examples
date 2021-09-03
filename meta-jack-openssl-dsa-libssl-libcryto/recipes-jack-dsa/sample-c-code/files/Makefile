
.PHONY: all clean

all: dsa_util

LIBS= -L. -lssl -lcrypto 
CFLAGS= -Wall -Wshadow

INCLUDE= -Iinclude -Iinclude/internal -Iinclude/openssl

%.o: %.c
	$(CC) $(INCLUDE) -c $< -o $@ $(LOCAL_CFLAGS)

dsa_util: dsa.o
	$(CC) $(INCLUDE) -c dsa.c $(LOCAL_CFLAGS) $(LOCAL_LFLAGS)  $(LIBS)
	$(CC) $(INCLUDE) -o $@ $< $(LOCAL_CFLAGS) $(LOCAL_LFLAGS)  $(LIBS)

clean:
	rm -f *.o *.a *.so dsa_util
