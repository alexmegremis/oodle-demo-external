# oodle-demo-external
By Alex Megremis
### Notes:
- This indeed uses a feign client and a consul for registration and discovery.
- This was my first ever contact with feign. The spec said to ignore it in this case, but I couldn't resist, I found it very interesting. Once I understood the fundamentals, and the basic functionality was there, it became interesting to see how it interacts with Spring. ~~The end result was that I mostly retired the traditional controller I'd written, and left just the feign interface.~~
  
  Somehow I actually needed to revert that. The request responses were being misrouted by spring. We're back to using a normal controller. 
    
  I did find an oddity worth discussing. It can be set to decode and pass a 404 response, but that behaviour only seems to work on `GET`s. The "internal API" `DELETE` has been written to return a 404 if an invalid ID is passed, and feign still chokes on that.
- This was also my first time with Consul. Again, the spec said to ignore, but I found it very interesting, so I dug in a bit. I had previously only played with Eureka.
  
  This is configured to register itself with a Consul container running in my homelab server.

##### URLs:
- External (this) : https://github.com/alexmegremis/oodle-demo-internal
- Internal : https://github.com/alexmegremis/oodle-demo-external
